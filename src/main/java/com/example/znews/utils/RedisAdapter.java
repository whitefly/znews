package com.example.znews.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisAdapter {
    private static final Logger logger = LoggerFactory.getLogger(RedisAdapter.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Long sAdd(String k, String... value) {
        // 在set增加
        try {
            SetOperations<String, String> sso = redisTemplate.opsForSet();
            return sso.add(k, value);
        } catch (Exception e) {
            logger.error("redis set 插入错误", e);
            return -1L;
        }
    }

    public void sRemove(String k, String element) {
        try {
            SetOperations<String, String> sso = redisTemplate.opsForSet();
            sso.remove(k, element);
        } catch (Exception e) {
            logger.error("redis set 删除错误", e);
        }
    }

    public Long sSize(String k) {
        // show the size of K
        try {
            SetOperations<String, String> sso = redisTemplate.opsForSet();
            long rnt = sso.size(k);
            return rnt;
        } catch (Exception e) {
            logger.error("redis set 查询错误", e);
        }
        return 0L;
    }


    public boolean isMember(String k, String element) {
        try {
            SetOperations<String, String> sso = redisTemplate.opsForSet();
            return sso.isMember(k, element);
        } catch (Exception e) {
            logger.error("redis set 查询错误", e);
        }
        return false;
    }


    public String getKV(String k) {
        ValueOperations operations = redisTemplate.opsForValue();
        Object o = operations.get(k);
        return o == null ? null : (String) o;
    }

    public void lPush(String key, String element) {
        ListOperations<String, String> sso = redisTemplate.opsForList();
        sso.leftPush(key, element);
    }

    public String rPop(String key) {
        ListOperations<String, String> sso = redisTemplate.opsForList();
        return sso.rightPop(key, 0, TimeUnit.MINUTES);
    }

    public Boolean zAdd(String key, String value, double weight) {
        try {
            ZSetOperations<String, String> zo = redisTemplate.opsForZSet();
            Boolean add = zo.add(key, value, weight);
            return add;
        } catch (Exception e) {
            logger.error("redis set 查询错误", e);
            return false;
        }
    }

    public Long zRemove(String key, String value) {
        try {
            ZSetOperations<String, String> zo = redisTemplate.opsForZSet();
            return zo.remove(key, value);
        } catch (Exception e) {
            logger.error("redis set 查询错误", e);
            return -1L;
        }
    }

    public Set<String> zRange(String key, long start, long end) {
        try {
            ZSetOperations<String, String> zo = redisTemplate.opsForZSet();
            return zo.range(key, start, end);
        } catch (Exception e) {
            logger.error("redis set 查询错误", e);
            return new HashSet<>();
        }
    }

    public Set<String> ZRevRange(String key, long start, long end) {
        try {
            ZSetOperations<String, String> zo = redisTemplate.opsForZSet();
            return zo.reverseRange(key, start, end);
        } catch (Exception e) {
            logger.error("redis set 查询错误", e);
            return new HashSet<>();
        }
    }

    public Long zCard(String key) {
        ZSetOperations<String, String> zo = redisTemplate.opsForZSet();
        return zo.zCard(key);
    }

    public Double zScore(String key, String name) {
        ZSetOperations<String, String> zo = redisTemplate.opsForZSet();
        return zo.score(key, name);
    }
}
