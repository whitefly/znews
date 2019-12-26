package com.example.znews.controller;

import com.example.znews.model.Question;
import com.example.znews.model.User;
import com.example.znews.model.ViewObject;
import com.example.znews.service.QuestionService;
import com.example.znews.service.UserService;
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

    @Autowired
    UserService userService;


    @Autowired
    QuestionService questionService;


    @GetMapping(path = "/")
    public String home(Model model) {
        List<Map<String, Object>> vos = new ArrayList<>();
        List<Question> latestQuestions = questionService.getLatestQuestions();
        for (Question q : latestQuestions) {
            int userId = q.getUserId();
            User user = userService.findUserById(userId);
            Map<String, Object> vo = new HashMap<>();
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
}
