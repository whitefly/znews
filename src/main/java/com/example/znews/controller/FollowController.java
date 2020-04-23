package com.example.znews.controller;

import com.alibaba.fastjson.JSON;
import com.example.znews.async.EventModel;
import com.example.znews.async.EventProducer;
import com.example.znews.async.EventType;
import com.example.znews.model.*;
import com.example.znews.service.CommentService;
import com.example.znews.service.FollowService;
import com.example.znews.service.QuestionService;
import com.example.znews.service.UserService;
import com.example.znews.utils.QuestionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;


    @ResponseBody
    @PostMapping(path = "/followUser")
    public String followUser(@RequestParam("userId") int userId) {

        User user = hostHolder.getUser();
        if (user == null) {
            return QuestionUtil.getCodeJson(999);
        }

        try {
            logger.info("用户[{}] 关注了 用户[{}]", user.getId(), userId);
            //关注对应id用户
            boolean follow = followService.follow(user.getId(), EntityType.ENTITY_USER, userId);
            if (follow) {
                //发送通知给被关注者
                EventModel event = new EventModel();
                event.setActorId(user.getId()).
                        setEntityType(EntityType.ENTITY_USER).
                        setEntityId(userId).
                        setEntityOwnerId(userId).
                        setEventType(EventType.FOLLOW);
                eventProducer.produceEvent(event);
                //返回关注者人数
                return QuestionUtil.getCodeJson(0, String.valueOf(followService.getFollowerCount(EntityType.ENTITY_USER, userId)));
            } else {
                return QuestionUtil.getCodeJson(-1);
            }
        } catch (Exception e) {
            logger.error("关注用户出错", e);
            return QuestionUtil.getCodeJson(-1);
        }
    }

    @ResponseBody
    @PostMapping(path = "/unFollowUser")
    public String unFollowUser(@RequestParam("userId") int userId) {
        User user = hostHolder.getUser();
        if (user == null) {
            return QuestionUtil.getCodeJson(999);
        }
        try {
            logger.info("用户[{}] 取消关注 用户[{}]", user.getId(), userId);
            //关注对应id用户
            boolean flag = followService.unFollow(user.getId(), EntityType.ENTITY_USER, userId);
            if (flag) {
                //发送通知给被关注者
                EventModel event = new EventModel();
                event.setActorId(user.getId()).
                        setEntityType(EntityType.ENTITY_USER).
                        setEntityId(userId).
                        setEntityOwnerId(userId).
                        setEventType(EventType.UNFOLLOW);
                eventProducer.produceEvent(event);
                //返回关注者人数
                return QuestionUtil.getCodeJson(0, String.valueOf(followService.getFollowerCount(EntityType.ENTITY_USER, userId)));
            } else {
                return QuestionUtil.getCodeJson(-1);
            }
        } catch (Exception e) {
            logger.error("关注用户出错", e);
            return QuestionUtil.getCodeJson(-1);
        }
    }

    @ResponseBody
    @PostMapping(path = "/followQuestion")
    public String followQuestion(@RequestParam("questionId") int questionId) {
        User user = hostHolder.getUser();
        if (user == null) {
            return QuestionUtil.getCodeJson(999);
        }
        try {
            //关注对应id用户
            logger.info("用户[{}] 关注了 问题[{}]", user.getId(), questionId);
            // TODO: 2020/4/23 此处应该发送一个follow消息,但是不知道怎么处理
            boolean flag = followService.follow(user.getId(), EntityType.ENTITY_QUESTION, questionId);
            if (flag) {
                //返回关注者人数
                return QuestionUtil.getCodeJson(0, String.valueOf(followService.getFollowerCount(EntityType.ENTITY_QUESTION, questionId)));
            } else {
                return QuestionUtil.getCodeJson(-1);
            }
        } catch (Exception e) {
            logger.error("关注问题出错", e);
            return QuestionUtil.getCodeJson(-1);
        }
    }

    @GetMapping(path = "/followees")
    public String followeeUserList(Model model) {
        User user = hostHolder.getUser();
        List<Integer> followeeIds = followService.getFollowees(user.getId(), EntityType.ENTITY_USER);

        List<User> usersById = userService.findUsersById(followeeIds);
        List<Map<String, Object>> vos = new ArrayList<>();
        for (User followee : usersById) {
            //获取关注该用户的用户数; 提问数和回答数
            long followerCount = followService.getFollowerCount(EntityType.ENTITY_USER, followee.getId());
            List<Question> questions = questionService.getQuestionByUser(user);
            List<Comment> answers = commentService.getAnswersByUser(user);

            Map<String, Object> vo = new HashMap<>();
            vo.put("followerCount", followerCount);
            vo.put("answerCount", answers.size());
            vo.put("questionCount", questions.size());
            vo.put("user", followee);
            vos.add(vo);
        }
        model.addAttribute("vos",vos);
        model.addAttribute("followeeCount", followeeIds.size());
        return "follow";
    }


}
