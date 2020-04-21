package com.example.znews.service;

import com.example.znews.dao.CommentDao;
import com.example.znews.dao.MessageDao;
import com.example.znews.dao.QuestionDao;
import com.example.znews.model.Message;
import com.example.znews.utils.SensitiveWordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private SensitiveWordsUtil sensitiveWordsUtil;

    @Autowired
    private MessageDao messageDao;


    public boolean addMessage(Message message) {
        //过滤内容
        message.setContent(sensitiveWordsUtil.filter(message.getContent()));
        return messageDao.insertMessage(message) > 0;
    }

    public List<Message> getMessagesByConversationId(String id, int offset, int limit) {
        return messageDao.getMessagesByConversationId(id, offset, limit);
    }

    public List<Message> getConversationList(int userId) {
        return messageDao.getConversationList(userId, 0, 10);
    }
}
