package com.example.znews.dao;

import com.example.znews.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDaoTest {

    @Autowired
    private MessageDao messageDao;

    @Test
    public void insertMessage() {
        Message message = new Message();
        message.setContent("求求你理一下我嘛");
        message.setConversationId("10_49");
        message.setCreatedDate(new Date());
        message.setFromId(49);
        message.setToId(10);
        messageDao.insertMessage(message);
    }

    @Test
    public void getMessagesByConversationId() {
        String conversationId = "11_14";
        int offset = 0;
        int limit = 2;
        List<Message> messagesByConversationId = messageDao.getMessagesByConversationId(conversationId, offset, limit);
        System.out.println(messagesByConversationId);
    }

    @Test
    public void getConversationList() {
        List<Message> conversationList = messageDao.getConversationList(49, 0, 10);
        System.out.println(conversationList);
    }
}