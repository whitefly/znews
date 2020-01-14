package com.example.znews.dao;

import com.example.znews.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MessageDao {

    Message findMessageById(@Param("id") int id);

    int insertMessage(Message Message);

    int deleteMessageById(int id);

    int updateMessage(Message Message);

    List<Message> getMessagesByConversationId(String conversationId, int offset, int limit);


    List<Message> getConversationList(int userId, int offset, int limit);

}
