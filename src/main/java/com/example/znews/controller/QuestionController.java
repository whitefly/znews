package com.example.znews.controller;


import com.example.znews.model.*;
import com.example.znews.service.*;
import com.example.znews.utils.QuestionUtil;
import com.example.znews.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class QuestionController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private FollowService followService;


    @PostMapping(path = "/question/add")
    @ResponseBody
    public String addQuestion(@RequestParam(name = "title") String title,
                              @RequestParam(name = "content") String content) {

        try {
            Question q = new Question();
            q.setTitle(title);
            q.setContent(content);
            //判断提问时,用户是否登录
            User user = hostHolder.getUser();
            q.setUserId(user != null ? user.getId() : UserUtil.ANONYMOUS_ID);

            q.setCommentCount(0);
            q.setCreatedDate(new Date());

            boolean rnt = questionService.addQuestion(q);
            return rnt ? QuestionUtil.getCodeJson(0, "") : QuestionUtil.getCodeJson(1, "问题");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return QuestionUtil.getCodeJson(1, "添加问题失败:" + e.toString());
        }
    }

    @GetMapping(path = "/question/{id}")
    public String questionDetail(@PathVariable(name = "id") int id, Model model) {
        Question question = questionService.getQuestionById(id);
        if (question == null) return "error/questionNotExist";
        model.addAttribute("question", question);
        //关注者的列表
        List<Integer> followerIds = followService.getFollowers(EntityType.ENTITY_QUESTION, id);
        model.addAttribute("followers", userService.findUsersById(followerIds));

        //问题下的回答
        List<Map<String, Object>> vos = new ArrayList<>();
        List<Comment> answers = commentService.getCommentByQuestion(question);

        User loginUser = hostHolder.getUser();
        for (Comment item : answers) {
            User user = userService.findUserById(item.getUserId());
            Map<String, Object> vo = new HashMap<>();
            vo.put("user", user);
            vo.put("comment", item);
            //回答赞的个数
            long likeCount = likeService.getLikeCount(EntityType.ENTITY_ANSWER, item.getId());
            vo.put("likeCount", likeCount);

            //登录用户赞的状态
            if (loginUser == null) {
                vo.put("liked", 0);
            } else {
                vo.put("liked", likeService.getLikeStatus(EntityType.ENTITY_ANSWER, item.getId(), loginUser.getId()));
            }
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        return "detail";
    }
}

