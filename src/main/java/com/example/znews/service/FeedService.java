package com.example.znews.service;

import com.example.znews.dao.FeedDao;
import com.example.znews.model.Feed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {

    @Autowired
    private FeedDao feedDao;


    public List<Feed> getUserFeeds(int maxId, List<Integer> userIds, int count) {
        //个人感觉在问题网站,如果不关注用户,就不应该返回feed流,直接看问题即可
        if (userIds == null || userIds.size() == 0) return new ArrayList<>();
        return feedDao.selectUserFeeds(maxId, userIds, count);
    }

    public boolean addFeed(Feed feed) {
        return feedDao.addFeed(feed) > 0;
    }


}
