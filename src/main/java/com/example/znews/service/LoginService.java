package com.example.znews.service;

import com.example.znews.dao.UserDao;
import com.example.znews.dao.UserTicketDao;
import com.example.znews.model.User;
import com.example.znews.model.UserTicket;
import com.example.znews.utils.PasswordUtil;
import com.example.znews.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTicketDao userTicketDao;


    public Map<String, String> register(String userName, String password) {
        Map<String, String> rnt = new HashMap<>();
        //重复用户检查
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            rnt.put("msg", "用户/密码为空");
        } else if (userDao.findUserByName(userName) != null) {
            rnt.put("msg", "用户已经被注册");
        } else {
            User user = new User();
            user.setName(userName);

            String salt = UUID.randomUUID().toString().substring(0, 8);
            user.setSalt(salt);
            user.setPassword(PasswordUtil.getSaltPassword(password, user.getSalt()));
            user.setHeadUrl(UserUtil.getRandomImageUrl());
            userDao.insertUser(user);
        }
        return rnt;
    }

    public Map<String, String> login(String userName, String password) {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            map.put("msg", "用户/密码为空");
            return map;
        }

        User user = userDao.findUserByName(userName);
        if (user == null) {
            map.put("msg", "不存在该用户");
            return map;
        }
        String saltPassword = PasswordUtil.getSaltPassword(password, user.getSalt());
        if (!saltPassword.equals(user.getPassword())) {
            map.put("msg", "账号/密码错误");
            return map;
        }
        //登录成功,增加session
        String ticket = addTicket(user.getId());
        logger.info("login success: user[{}]", user.getName());
        map.put("ticket", ticket);
        return map;
    }

    public String addTicket(int userId) {
        UserTicket ticket = new UserTicket();
        ticket.setUserId(userId);
        ticket.setStatus(0);// 状态0位为有效
        Date now = new Date();
        now.setTime(now.getTime() + 30 * 24 * 3600);
        ticket.setExpired(now);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        userTicketDao.insertUserTicket(ticket);
        return ticket.getTicket();
    }

    public void logout(String ticket) {
        //用户退出的逻辑
        UserTicket userTicket = userTicketDao.findQuestionByTicket(ticket);
        if (userTicket != null) {
            userTicket.setStatus(1);
            userTicketDao.updateUserTicket(userTicket);
        }
    }


}
