package com.example.znews.controller;

import com.example.znews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/index/{userId}")
    @ResponseBody
    public String index(@PathVariable(value = "userId") int id, @RequestParam(value = "name", required = false) String name) {
        return userService.demo().toString();
    }
}
