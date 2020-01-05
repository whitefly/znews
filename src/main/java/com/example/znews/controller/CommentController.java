package com.example.znews.controller;

import com.example.znews.model.Comment;
import com.example.znews.model.CommentType;
import com.example.znews.model.HostHolder;
import com.example.znews.model.User;
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
    ;


    @Autowired
    private CommentService commentService;

    @Autowired
    private HostHolder hostHolder;

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
            comment.setEntityType(CommentType.ENTITY_QUESTION);
            comment.setEntityId(questionId);
            commentService.addComment(comment);
        } catch (Exception e) {
            logger.error("增加评论失败", e);
        }
        return "redirect:/question/" + questionId;
    }
}
