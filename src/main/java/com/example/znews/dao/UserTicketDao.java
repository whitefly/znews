package com.example.znews.dao;

import com.example.znews.model.UserTicket;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserTicketDao {

    int insertUserTicket(UserTicket userTicket);

    UserTicket findQuestionByTicket(String ticket);

    void updateUserTicket(UserTicket ticket);


}
