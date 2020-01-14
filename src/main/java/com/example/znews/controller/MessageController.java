package com.example.znews.controller;

import com.example.znews.model.Comment;
import com.example.znews.model.HostHolder;
import com.example.znews.model.Message;
import com.example.znews.model.User;
import com.example.znews.service.MessageService;
import com.example.znews.service.UserService;
import com.example.znews.utils.MessageUtil;
import com.example.znews.utils.QuestionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @PostMapping(path = "/message/add")
    @ResponseBody
    public String addMessage(@RequestParam("toId") int toId, @RequestParam("content") String content) {
        try {
            User sender = hostHolder.getUser();
            //需要用户登录才能发送消息
            if (sender == null) return QuestionUtil.getCodeJson(999, "用户未登录");

            User accepter = userService.findUserById(toId);
            if (accepter == null) {
                //接受者不存在错误
                return QuestionUtil.getCodeJson(998, "用户不存在");
            } else {
                Message message = new Message();
                message.setFromId(sender.getId());
                message.setToId(accepter.getId());
                message.setContent(content);
                message.setCreatedDate(new Date());
                message.setConversationId(MessageUtil.generateConversationId(sender.getId(), accepter.getId()));
                boolean flag = messageService.addMessage(message);
                return QuestionUtil.getCodeJson(0, "发送成功");
            }
        } catch (Exception e) {
            logger.error("消息发送失败", e);
            return QuestionUtil.getCodeJson(1, "消息发送错误");
        }
    }

    @GetMapping(path = "/message/list")
    public String getMessageList(Model model) {
        User user = hostHolder.getUser();
        if ((user == null)) return "redirect:/loginPage";

        List<Message> conversations = messageService.getConversationList(user.getId());
        List<Map<String, Object>> vos = new ArrayList<>();
        for (Message item : conversations) {
            Map<String, Object> vo = new HashMap<>();
            vo.put("message", item);
            int targetId = item.getFromId() == user.getId() ? item.getToId() : item.getFromId();
            User otherSide = userService.findUserById(targetId);
            vo.put("user", otherSide);
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        return "letter";
    }

    @GetMapping(path = "/message/detail")
    public String getMessageDetail(Model model, @RequestParam(name = "conversation") String conversationId) {
        try {
            List<Map<String, Object>> vos = new ArrayList<>();
            List<Message> conversation = messageService.getMessagesByConversationId(conversationId, 0, 10);
            for (Message msg : conversation) {
                Map<String, Object> vo = new HashMap<>();
                User user = userService.findUserById(msg.getFromId());
                vo.put("user", user);
                vo.put("message", msg);
                vos.add(vo);
            }

            model.addAttribute("vos", vos);
            return "letterDetail";
        } catch (Exception e) {
            logger.error("查询站内消息失败", e);
            return "error/404";
        }

    }
}
