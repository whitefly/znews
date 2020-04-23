package com.example.znews.service;

import com.example.znews.utils.RedisAdapter;
import com.example.znews.utils.RedisKeyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class FollowService {
    private static final Logger logger = LoggerFactory.getLogger(FollowService.class);

    @Autowired
    private RedisAdapter redisAdapter;

    @Autowired
    private StringRedisTemplate redisTemplate;


    public boolean follow(int userId, int entityType, int entityId) {
        //用户点击后关注某个用户或者实体.
        //设计到2个列表同时修改,so需要redis 的事务
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId, entityType);

        //开始redis事务
        Date date = new Date();
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisAdapter.zAdd(followerKey, String.valueOf(userId), date.getTime());
        redisAdapter.zAdd(followeeKey, String.valueOf(entityId), date.getTime());
        List<Object> rnt = redisTemplate.exec();
        return rnt.size() == 2 && (Boolean) rnt.get(0) && (Boolean) rnt.get(1);
    }


    public boolean unFollow(int userId, int entityType, int entityId) {

        //用户点击后关注某个用户或者实体.
        //设计到2个列表同时修改,so需要redis 的事务
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId, entityType);

        //开始redis事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.multi();
        redisAdapter.zRemove(followerKey, String.valueOf(userId));
        redisAdapter.zRemove(followeeKey, String.valueOf(entityId));
        List<Object> rnt = redisTemplate.exec();
        return rnt.size() == 2 && (Long) rnt.get(0) > 0 && (Long) rnt.get(1) > 0;
    }

    private List<Integer> string2Int(Set<String> set) {
        List<Integer> result = new ArrayList<>();
        if (set == null) return result;
        for (String id : set) {
            result.add(Integer.parseInt(id));
        }
        return result;
    }

    public List<Integer> getFollowers(int entityType, int entityId, int count) {
        //count用来分页
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        Set<String> ids = redisAdapter.ZRevRange(followerKey, 0, count);
        return string2Int(ids);
    }

    public List<Integer> getFollowees(int userId, int entityType, int count) {
        //count用来分页
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId, entityType);
        Set<String> ids = redisAdapter.ZRevRange(followeeKey, 0, count);
        return string2Int(ids);
    }


    public List<Integer> getFollowers(int entityType, int entityId, int start, int count) {
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        Set<String> ids = redisAdapter.ZRevRange(followerKey, start, start + count);
        return string2Int(ids);
    }

    public List<Integer> getFollowees(int userId, int entityType, int start, int count) {
        //count用来分页
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId, entityType);
        Set<String> ids = redisAdapter.ZRevRange(followeeKey, start, start + count);
        return string2Int(ids);
    }

    public List<Integer> getFollowers(int entityType, int entityId) {
        return getFollowers(entityType, entityId, -1);
    }

    public List<Integer> getFollowees(int userId, int entityType) {
        return getFollowees(userId, entityType, -1);
    }

    public long getFollowerCount(int entityType, int entityId) {
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        return redisAdapter.zCard(followerKey);
    }


    public long getFolloweeCount(int userId, int entityType) {
        String followeeKey = RedisKeyUtil.getFolloweeKey(userId, entityType);
        return redisAdapter.zCard(followeeKey);
    }

    public boolean isFollower(int entityType, int entityId, int userId) {
        String followerKey = RedisKeyUtil.getFollowerKey(entityType, entityId);
        Double score = redisAdapter.zScore(followerKey, String.valueOf(userId));
        return score != null;
    }

}
