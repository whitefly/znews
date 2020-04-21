package com.example.znews.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowServiceTest {

    @Autowired
    private FollowService followService;

    @Test
    public void follow() {
        int userId = 200;
        int entityType = 0;
        int entityId = 19;
        followService.follow(userId, entityType, entityId);
    }

    @Test
    public void unFollow() {
        int userId = 200;
        int entityType = 0;
        int entityId = 19;
        followService.unFollow(userId, entityType, entityId);
    }

    @Test
    public void getFollowers() {
        int entityType = 0;
        int entityId = 19;
        List<Integer> followers = followService.getFollowers(entityType, entityId);
        System.out.println(followers);
    }

    @Test
    public void getFollowerCount() {
        int entityType = 0;
        int entityId = 19;
        Assert.assertEquals(2, followService.getFollowerCount(entityType, entityId));
    }

    @Test
    public void isFollower() {
        int entityType = 0;
        int entityId = 19;
        int userId = 123;
        Assert.assertEquals(true, followService.isFollower(entityType, entityId, userId));

        Assert.assertEquals(false, followService.isFollower(entityType, entityId, 0));

    }
}