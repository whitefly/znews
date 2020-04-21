package com.example.znews.service;

import com.example.znews.dao.UserDao;
import com.example.znews.model.User;
import com.example.znews.utils.RedisAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisAdapter redisService;


    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void addUser() throws IOException {
//        User user = userDao.findUserById(50);
        ObjectMapper mapper = new ObjectMapper();
//        String rnt = mapper.writeValueAsString(user);
//        redisService.addKV("user", rnt);

        String userJson = redisService.getKV("user");
        User user = mapper.readValue(userJson, User.class);
        System.out.println(user);


    }

    @Test
    public void sAdd() {
        String name1 = "zhou";
        String name2 = "zhang";
        String name3 = "mo";
        redisService.sAdd("praiseDemo", name1, name2, name3);
    }


    @Test
    public void multiTest() {
//        stringRedisTemplate.setEnableTransactionSupport(true);
        stringRedisTemplate.multi();
        ValueOperations vo = stringRedisTemplate.opsForValue();
        vo.set("hehe", "ysw");
        vo.set("fuck", "ysw");
        int i = 1 / 0;
        stringRedisTemplate.exec();
    }
}