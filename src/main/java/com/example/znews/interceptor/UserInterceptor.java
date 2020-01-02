package com.example.znews.interceptor;


import com.example.znews.dao.UserDao;
import com.example.znews.dao.UserTicketDao;
import com.example.znews.model.HostHolder;
import com.example.znews.model.User;
import com.example.znews.model.UserTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@Component
public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    private UserTicketDao userTicketDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        UserTicket userTicket = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("ticket".equals(cookie.getName())) {
                    String ticket = cookie.getValue();
                    userTicket = userTicketDao.findQuestionByTicket(ticket);
                    break;
                }
            }
            //判断ticket的有效性
            if (userTicket != null && userTicket.getStatus() == 0 && userTicket.getExpired().after(new Date())) {
                //ticket有效,设置为临时全局变量
                User user = userDao.findUserById(userTicket.getUserId());
                hostHolder.setUsers(user);

            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //准备返回model,进行渲染数据时
        if (modelAndView != null) {
            modelAndView.addObject("user", hostHolder.getUser());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
