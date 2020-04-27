package com.example.znews.dao;

import com.example.znews.model.Feed;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedDaoTest {

    @Autowired
    private FeedDao feedDao;

    @Test
    public void addFeed() {
        for (int i = 0; i < 10; i++) {
            Feed feed = new Feed();
            feed.setCreatedDate(new Date());
            feed.setType(1);
            feed.setUserId(i);
            feed.setData(String.format("{num:%d}", i));
            feedDao.addFeed(feed);
        }
    }

    @Test
    public void selectUserFeeds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(14);
        List<Feed> feeds = feedDao.selectUserFeeds(20, ids, 10);
        System.out.println(feeds);
    }

    @Test
    public void findFeedById() {
        int id = 1;
        Feed feedById = feedDao.findFeedById(id);
        Assert.assertEquals("{name:haha}", feedById.getData());
        ;
    }
}