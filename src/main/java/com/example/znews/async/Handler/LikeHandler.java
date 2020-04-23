package com.example.znews.async.Handler;

import com.example.znews.async.EventHandler;
import com.example.znews.async.EventModel;
import com.example.znews.async.EventType;
import com.example.znews.model.Message;
import com.example.znews.model.User;
import com.example.znews.service.MessageService;
import com.example.znews.service.UserService;
import com.example.znews.utils.MessageUtil;
import com.example.znews.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class LikeHandler implements EventHandler {
    private static final Logger logger = LoggerFactory.getLogger(LikeHandler.class);
    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Override
    public void doHandle(EventModel event) {
        logger.info("处理event:" + event.toString());
        //点赞时,给被点赞的人发通知,会跳到问题页面
        Message message = new Message();
        message.setFromId(UserUtil.SYSTEM_ID);
        message.setToId(event.getEntityOwnerId());
        message.setCreatedDate(new Date());

        User user = userService.findUserById(event.getActorId());
        String link = String.format("http://127:0.0.1:8080/comment/%s", event.getExt("CommentId"));
        message.setContent("用户 " + user.getName() + " 赞了你的评论,回答连接:" + link);
        message.setConversationId(MessageUtil.generateConversationId(message.getFromId(), message.getToId()));
        messageService.addMessage(message);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LIKE);
    }
}
