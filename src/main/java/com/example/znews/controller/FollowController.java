package com.example.znews.controller;

import com.alibaba.fastjson.JSON;
import com.example.znews.async.EventModel;
import com.example.znews.async.EventProducer;
import com.example.znews.async.EventType;
import com.example.znews.model.EntityType;
import com.example.znews.model.HostHolder;
import com.example.znews.model.User;
import com.example.znews.service.FollowService;
import com.example.znews.utils.QuestionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class FollowController {
    private static final Logger logger = LoggerFactory.getLogger(FollowController.class);

    @Autowired
    private FollowService followService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private EventProducer eventProducer;


    @ResponseBody
    @PostMapping(path = "/follow/followUser")
    public String follow(@RequestParam("userId") int userId) {
        User user = hostHolder.getUser();
        if (user == null) {
            return QuestionUtil.getCodeJson(999);
        }
        try {
            //关注对应id用户
            boolean follow = followService.follow(user.getId(), EntityType.ENTITY_USER, userId);
            if (follow) {
                //发送通知给被关注者
                EventModel event = new EventModel();
                event.setActorId(user.getId());
                event.setEntityType(EntityType.ENTITY_USER);
                event.setEntityId(userId);
                event.setEntityOwnerId(userId);
                event.setEventType(EventType.FOLLOW);
                eventProducer.produceEvent(event);

                //返回关注者人数
                long count = followService.getFollowerCount(EntityType.ENTITY_USER, userId);
                Map<String, Long> map = new HashMap<>();
                map.put("count", count);
                return QuestionUtil.getCodeJson(0, JSON.toJSONString(map));
            } else {
                return QuestionUtil.getCodeJson(-1);
            }
        } catch (Exception e) {
            logger.error("关注用户出错", e);
            return QuestionUtil.getCodeJson(-1);
        }
    }

    @ResponseBody
    @PostMapping(path = "/follow/unFollowUser")
    public String unfollow(@RequestParam("userId") int userId) {
        return "1";
    }


}
