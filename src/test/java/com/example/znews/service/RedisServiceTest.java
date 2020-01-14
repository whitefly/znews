package com.example.znews.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Test
    public void addkv() {
        String k = "goodman";
        String v = "123456";
        redisService.addKV(k, v);
    }

    @Test
    public void addKVExpired() {
        String k = "zhouang";
        String v = "123456";
        redisService.addKVExpired(k, v, 10);
    }
}