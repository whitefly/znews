package com.example.znews.controller;

import com.example.znews.model.*;
import com.example.znews.service.*;
import com.example.znews.utils.WendaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class FeedController {

    private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

    @Autowired
    FeedService feedService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    FollowService followService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    @GetMapping(path = "/feeds")
    public String pullFeed(Model model) {
        //关注大V用户的动态
        try {
            User user = hostHolder.getUser();
            List<Feed> feeds = null;
            if (user == null) {
                //未登录用户,不返回
                feeds = feedService.getUserFeeds(Integer.MAX_VALUE, null, 10);
            } else {
                //查询出所有关注的人,没有关注的人,就会推送全部
                List<Integer> followees = followService.getFollowees(user.getId(), EntityType.ENTITY_USER);
                feeds = feedService.getUserFeeds(Integer.MAX_VALUE, followees, 10);
            }
            model.addAttribute("feeds", feeds);
        } catch (Exception e) {
            logger.error("feeds查询出错", e);
        }
        return "feeds";
    }

    @GetMapping(path = "/user/{id}")
    public String profile(Model model, @PathVariable(name = "id") int id) {
        //返回这个id的最新动态即可
        User userById = userService.findUserById(id);
        try {
            if (userById == null) return "error/questionNotExist";
            List<Integer> ids = Collections.singletonList(userById.getId());
            List<Feed> feeds = feedService.getUserFeeds(Integer.MAX_VALUE, ids, 10);
            model.addAttribute("feeds", feeds);
            return "feeds";
        } catch (Exception e) {
            logger.error("出错",e);
        }
        return "error/questionNotExist";
    }

    @GetMapping(path = "/questionFeed")
    public String questionFeed(Model model) {
        //关注问题的动态
        User user = hostHolder.getUser();
        List<Integer> questionIds = followService.getFollowees(user.getId(), EntityType.ENTITY_QUESTION);
        List<Comment> answers = commentService.getAnswersByEntities(questionIds);
        List<Map<String, Object>> vos = new ArrayList<>();
        for (Comment answer : answers) {
            answer.setContent(WendaUtil.previewContent(answer.getContent()));
            Map<String, Object> vo = new HashMap<>();
            User u = userService.findUserById(answer.getUserId());
            Question question = questionService.getQuestionById(answer.getEntityId());
            vo.put("answer", answer);
            vo.put("user", u);
            vo.put("question", question);
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        return "followeeQuestion";
    }


}
