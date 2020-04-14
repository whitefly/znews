package com.example.znews.async;

import com.alibaba.fastjson.JSON;
import com.example.znews.utils.RedisAdapter;
import com.example.znews.utils.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventConsumer implements InitializingBean {

    private Map<EventType, List<EventHandler>> handlerMap;
    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RedisAdapter redisAdapter;


    @Override
    public void afterPropertiesSet() throws Exception {
        //填充映射信息
        handlerMap = new HashMap<>();
        Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
        for (Map.Entry<String, EventHandler> element : beans.entrySet()) {
            EventHandler handler = element.getValue();
            List<EventType> supportEventTypes = handler.getSupportEventTypes();
            for (EventType type : supportEventTypes) {
                List<EventHandler> channel = handlerMap.get(type);
                if (channel == null) {
                    channel = new ArrayList<>();
                    handlerMap.put(type, channel);
                }
                channel.add(handler);
            }
        }
        //开启线程来处理消息的分发
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String eventJson = redisAdapter.rPop(RedisKeyUtil.getEventQueueKey());
                        EventModel eventModel = JSON.parseObject(eventJson, EventModel.class);
                        if (!handlerMap.containsKey(eventModel.getEventType())) {
                            logger.warn("无法处理该消息类型" + eventModel.getEventType());
                            continue;
                        }

                        List<EventHandler> eventHandlers = handlerMap.get(eventModel.getEventType());
                        if (eventHandlers != null) {
                            for (EventHandler handler : eventHandlers) {
                                handler.doHandle(eventModel);
                            }
                        }
                    } catch (QueryTimeoutException e) {
                        logger.error("超时:从redis的队列中取出事件超时", e);
                    }
                }
            }
        });
        consumerThread.start();

    }
}
