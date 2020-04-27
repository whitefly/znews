package com.example.znews.controller;

import com.example.znews.async.EventModel;
import com.example.znews.async.EventProducer;
import com.example.znews.async.EventType;
import com.example.znews.model.Comment;
import com.example.znews.model.EntityType;
import com.example.znews.model.HostHolder;
import com.example.znews.model.User;
import com.example.znews.service.CommentService;
import com.example.znews.service.LikeService;
import com.example.znews.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LikeController {

    private static final Logger logger = LoggerFactory.getLogger(LikeController.class);

    @Autowired
    private LikeService likeService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/like")
    @ResponseBody
    public String like(@RequestParam("commentId") int commentId) {
        //点赞
        logger.info("收到点赞请求:" + commentId);
        try {
            User user = hostHolder.getUser();
            if (user == null) {
                return ResponseUtil.getCodeJson(999);
            }
            Comment comment = commentService.getCommentById(commentId);
            //若重复点赞,这里会报错
            int likeStatus = likeService.getLikeStatus(EntityType.ENTITY_ANSWER, commentId, user.getId());
            if (likeStatus == 1) {
                //已经有点赞,再次点击表示取消点赞
                logger.info("用户[{}]取消了答案[{}]", user.getId(), comment.getId());
                likeService.cancelLike(EntityType.ENTITY_ANSWER, commentId, user.getId());
            } else {
                //点赞
                likeService.like(EntityType.ENTITY_ANSWER, commentId, user.getId());
                EventModel event = new EventModel(EventType.LIKE).
                        setEntityType(EntityType.ENTITY_ANSWER).
                        setEntityId(commentId).
                        setActorId(user.getId()).
                        setEntityOwnerId(comment.getUserId()).
                        setExt("CommentId", String.valueOf(commentId));
                eventProducer.produceEvent(event);
            }
            long likeCount = likeService.getLikeCount(EntityType.ENTITY_ANSWER, commentId);
            //发通知,这里的'CommentId'必须设置,否则给用户的通知中无法找到对应的回答连接
            return ResponseUtil.getCodeJson(0, String.valueOf(likeCount));
        } catch (Exception e) {
            logger.error("点赞错误", e);
            return ResponseUtil.getCodeJson(-1, "some error exist");
        }
    }

    @PostMapping(path = "/dislike")
    @ResponseBody
    public String dislike(@RequestParam("commentId") int commentId) {
        //点赞
        try {
            User user = hostHolder.getUser();
            if (user == null) {
                return ResponseUtil.getCodeJson(999);
            }

            long dislikeCount = likeService.dislike(EntityType.ENTITY_ANSWER, commentId, user.getId());
            return ResponseUtil.getCodeJson(0, String.valueOf(dislikeCount));
        } catch (Exception e) {
            return ResponseUtil.getCodeJson(-1, "some error exist");
        }
    }


}
