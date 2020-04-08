package com.example.znews.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LikeServiceTest {

    @Autowired
    private LikeService likeService;

    @Test
    public void like() {
        int entityType = 0;
        int entityId = 112;
        int userId = 14;
        likeService.like(entityType, entityId, userId);
    }

    @Test
    public void dislike() {
        int entityType = 0;
        int entityId = 112;
        int userId = 13;
        likeService.dislike(entityType, entityId, userId);
    }

    @Test
    public void getLikeStatus() {
        int entityType = 0;
        int entityId = 112;
        int userId = 13;
        Assert.assertEquals(-1, likeService.getLikeStatus(entityType, entityId, userId));
    }

    @Test
    public void getLikeCount() {
        int entityType = 0;
        int entityId = 112;
        Assert.assertEquals(2, likeService.getLikeCount(entityType, entityId));


        Assert.assertEquals(0, likeService.getLikeCount(entityType, 2121121));

    }
}