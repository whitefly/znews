package com.example.znews.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private static final Logger logger = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addKV(String k, String v) {
        try {
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(k, v);
        } catch (Exception e) {
            logger.error("插入redis出错", e);
        }
    }

    public void addKVExpired(String k, String v, int time) {
        try {
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(k, v, time);
        } catch (Exception e) {
            logger.error("插入redis出错", e);
        }
    }


}
