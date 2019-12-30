package com.example.znews.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);

    @Autowired
    LoginService loginService;

    @Test
    public void register() {
        String name = "whiteFly";
        String password = "123456";
        Map<String, String> register = loginService.register(name, password);
        Assert.assertEquals(register.get("msg"), "注册成功");
    }

    @Test
    public void login() {
        String userName = "sanduo";
        String password = "123456";
        Map<String, String> login = loginService.login(userName, password);
        System.out.println(login);
    }
}