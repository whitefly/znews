package com.example.znews.controller;

import com.example.znews.model.EntityType;
import com.example.znews.model.Question;
import com.example.znews.model.User;
import com.example.znews.service.LikeService;
import com.example.znews.service.LoginService;
import com.example.znews.service.QuestionService;
import com.example.znews.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;


    @Autowired
    private QuestionService questionService;

    @Autowired
    private LikeService likeService;


    @GetMapping(path = "/")
    public String home(Model model) {
        List<Map<String, Object>> vos = new ArrayList<>();
        List<Question> latestQuestions = questionService.getLatestQuestions();
        for (Question q : latestQuestions) {
            int userId = q.getUserId();
            User user = userService.findUserById(userId);
            Map<String, Object> vo = new HashMap<>();
            //问题的获赞数量
            vo.put("question", q);
            vo.put("user", user);
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        return "index";
    }

    @GetMapping(path = "/demo")
    public String demo(Model mv) {
        List<Question> result = questionService.getLatestQuestions();
        mv.addAttribute("questions", result);
        return "hello";
    }

    @GetMapping(path = "/error")
    public String handleError() {
        return "error/404"; // 该资源位于resources/static目录下
    }
}
