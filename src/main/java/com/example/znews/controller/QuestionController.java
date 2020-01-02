package com.example.znews.controller;


import com.example.znews.model.HostHolder;
import com.example.znews.model.Question;
import com.example.znews.model.User;
import com.example.znews.service.QuestionService;
import com.example.znews.utils.QuestionUtil;
import com.example.znews.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private QuestionService questionService;


    @PostMapping(path = "/question/add")
    public String addQuestion(@RequestParam(name = "title") String title,
                              @RequestParam(name = "content") String content) {

        try {
            Question q = new Question();
            q.setTitle(title);
            q.setContent(content);
            //判断提问时,用户是否登录
            User user = hostHolder.getUser();
            q.setUserId(user != null ? user.getId() : UserUtil.ANONYMOUS_ID);

            q.setCommentCount(0);
            q.setCreatedDate(new Date());

            boolean rnt = questionService.addQuestion(q);
            return rnt ? QuestionUtil.getCodeJson(0, "") : QuestionUtil.getCodeJson(1, "问题");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return QuestionUtil.getCodeJson(1, "添加问题失败:" + e.toString());
        }
    }
}

