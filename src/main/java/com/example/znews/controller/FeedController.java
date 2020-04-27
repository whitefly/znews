package com.example.znews.controller;

import com.example.znews.model.EntityType;
import com.example.znews.model.Feed;
import com.example.znews.model.HostHolder;
import com.example.znews.model.User;
import com.example.znews.service.FeedService;
import com.example.znews.service.FollowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FeedController {

    private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

    @Autowired
    FeedService feedService;

    @Autowired
    HostHolder hostHolder;


    @Autowired
    FollowService followService;

    @GetMapping(path = "/feeds")
    public String pullFeed(Model model) {
        User user = hostHolder.getUser();
        List<Feed> feeds = null;
        if (user == null) {
            //未登录用户,返回所有资讯
            feeds = feedService.getUserFeeds(Integer.MAX_VALUE, null, 10);
        } else {
            //查询出所有关注的人,没有关注的人,就会推送全部
            List<Integer> followees = followService.getFollowees(user.getId(), EntityType.ENTITY_USER);
            feeds = feedService.getUserFeeds(Integer.MAX_VALUE, followees, 10);
        }
        model.addAttribute("feeds", feeds);
        return "feeds";
    }
}
