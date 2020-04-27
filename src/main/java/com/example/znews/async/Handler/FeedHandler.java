package com.example.znews.async.Handler;

import com.alibaba.fastjson.JSON;
import com.example.znews.async.EventHandler;
import com.example.znews.async.EventModel;
import com.example.znews.async.EventType;
import com.example.znews.model.*;
import com.example.znews.service.CommentService;
import com.example.znews.service.FeedService;
import com.example.znews.service.QuestionService;
import com.example.znews.service.UserService;
import com.example.znews.utils.WendaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FeedHandler implements EventHandler {

    private static final Logger logger = LoggerFactory.getLogger(FeedHandler.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private FeedService feedService;


    private String buildFeedData(EventModel eventModel) {
        //设置feed流每个单元的具体内容,map->json
        Map<String, String> map = new HashMap<>();
        User actor = userService.findUserById(eventModel.getActorId());
        //头像
        map.put("headUrl", actor.getHeadUrl());
        map.put("userId", String.valueOf(actor.getId()));
        map.put("userName", actor.getName());

        if ((eventModel.getEventType() == EventType.FOLLOW && eventModel.getEntityType() == EntityType.ENTITY_QUESTION)
                || (eventModel.getEventType() == EventType.QUESTION)) {
            // 创建or关注问题
            Question question = questionService.getQuestionById(eventModel.getEntityId());
            if (question == null) return null;
            map.put("questionId", String.valueOf(question.getId()));
            map.put("questionTitle", question.getTitle());
            return JSON.toJSONString(map);
        } else if (eventModel.getEventType() == EventType.COMMENT && eventModel.getEntityType() == EntityType.ENTITY_ANSWER) {
            //用户回答了问题
            Comment comment = commentService.getCommentById(eventModel.getEntityId());
            if (comment == null) return null;
            map.put("answerId", String.valueOf(comment.getId()));
            map.put("answerPreview", WendaUtil.previewContent(comment.getContent()));
            return JSON.toJSONString(map);
        } else if (eventModel.getEventType() == EventType.LIKE) {
            //用户点赞了回答
            Comment comment = commentService.getCommentById(eventModel.getEntityId());
            map.put("answerId", String.valueOf(comment.getId()));
            map.put("answerPreview", WendaUtil.previewContent(comment.getContent()));
            return JSON.toJSONString(map);
        }
        return null;

    }

    @Override
    public void doHandle(EventModel eventModel) {
        //将评论这个事件转化为一个feed
        logger.info("开始处理event:{}", eventModel);
        Feed feed = new Feed();
        feed.setCreatedDate(new Date());
        feed.setUserId(eventModel.getActorId());
        feed.setType(eventModel.getEventType().getValue());
        feed.setData(buildFeedData(eventModel));

        if (feed.getData() != null) {
            feedService.addFeed(feed);
        }

    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LIKE, EventType.COMMENT, EventType.QUESTION,EventType.FOLLOW);
    }
}
