package com.example.znews.controller;

import com.example.znews.model.CommentType;
import com.example.znews.model.HostHolder;
import com.example.znews.model.User;
import com.example.znews.service.LikeService;
import com.example.znews.utils.QuestionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private HostHolder hostHolder;

    @PostMapping(path = "/like/like")
    @ResponseBody
    public String like(@RequestParam("commentId") String commentId) {
        //点赞
        try {
            User user = hostHolder.getUser();
            if (user == null) {
                return QuestionUtil.getCodeJson(999);
            }

            long likeCount = likeService.like(CommentType.ENTITY_ANSWER, Integer.parseInt(commentId), user.getId());
            return QuestionUtil.getCodeJson(0, String.valueOf(likeCount));
        } catch (Exception e) {
            return QuestionUtil.getCodeJson(-1, "some error exist");
        }
    }

    @PostMapping(path = "/like/dislike")
    @ResponseBody
    public String dislike(@RequestParam("commentId") String commentId) {
        //点赞
        try {
            User user = hostHolder.getUser();
            if (user == null) {
                return QuestionUtil.getCodeJson(999);
            }

            long dislikeCount = likeService.dislike(CommentType.ENTITY_ANSWER, Integer.parseInt(commentId), user.getId());
            return QuestionUtil.getCodeJson(0, String.valueOf(dislikeCount));
        } catch (Exception e) {
            return QuestionUtil.getCodeJson(-1, "some error exist");
        }
    }


}
