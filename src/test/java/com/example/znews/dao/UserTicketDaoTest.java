package com.example.znews.dao;

import com.example.znews.model.User;
import com.example.znews.model.UserTicket;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTicketDaoTest {


    @Autowired
    private UserTicketDao userTicketDao;

    @Test
    public void insertUserTicket() {
        UserTicket ticket = new UserTicket();
        ticket.setUserId(4);
        ticket.setStatus(0);
        ticket.setExpired(new Date());
        ticket.setTicket("sadlhkaslj2jkjskjdlkasoicui3nxc");
        userTicketDao.insertUserTicket(ticket);
    }

    @Test
    public void findQuestionByTicket() {
        String target = "sadlhkaslj2jkjskjdlkasoicui3nxc";
        UserTicket item = userTicketDao.findQuestionByTicket(target);
        Assert.assertEquals(4, item.getUserId());
    }

    @Test
    public void updateUserTicket() {
        String target = "sadlhkaslj2jkjskjdlkasoicui3nxc";
        UserTicket item = userTicketDao.findQuestionByTicket(target);
        item.setStatus(1);
        userTicketDao.updateUserTicket(item);
        Assert.assertEquals(1, userTicketDao.findQuestionByTicket(target).getStatus());
    }
}