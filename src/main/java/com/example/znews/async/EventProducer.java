package com.example.znews.async;

import com.alibaba.fastjson.JSON;
import com.example.znews.utils.RedisAdapter;
import com.example.znews.utils.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {
    @Autowired
    private RedisAdapter redisAdapter;


    public boolean produceEvent(EventModel eventModel) {
        try {
            String eventJson = JSON.toJSONString(eventModel);
            String key = RedisKeyUtil.getEventQueueKey();
            redisAdapter.lPush(key, eventJson);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
