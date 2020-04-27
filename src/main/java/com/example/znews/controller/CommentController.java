package com.example.znews.controller;

import com.example.znews.async.EventModel;
import com.example.znews.async.EventProducer;
import com.example.znews.async.EventType;
import com.example.znews.model.*;
import com.example.znews.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);


    @Autowired
    private CommentService commentService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private EventProducer eventProducer;

    //回答问题
    @PostMapping(path = "/comment/add")
    public String addComment(@RequestParam(name = "questionId") int questionId, @RequestParam("content") String content) {
        try {
            User user = hostHolder.getUser();
            if (user == null) {
                return "redirect:/loginPage";
            }

            Comment comment = new Comment();
            comment.setCreatedDate(new Date());
            comment.setContent(content);
            comment.setUserId(user.getId());
            comment.setEntityType(EntityType.ENTITY_QUESTION); //针对问题的评论->回答
            comment.setEntityId(questionId);
            int id = commentService.addComment(comment);

            if (id > 0) {
                //发送回答消息
                EventModel eventModel = new EventModel().setEventType(EventType.COMMENT).setActorId(user.getId()).setEntityType(EntityType.ENTITY_ANSWER).setEntityId(comment.getId()).setEntityOwnerId(user.getId());
                eventProducer.produceEvent(eventModel);
            }


        } catch (Exception e) {
            logger.error("增加评论失败", e);
        }
        return "redirect:/question/" + questionId;
    }
}
