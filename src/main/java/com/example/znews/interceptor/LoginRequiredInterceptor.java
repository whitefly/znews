package com.example.znews.interceptor;

import com.example.znews.model.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    private static String loginUrl = "/loginPage";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果这是一个需要登录的url,在get方法后加个参数+调整
        if (hostHolder.getUser() == null) {
            response.sendRedirect(loginUrl + "?next=" + request.getRequestURI());
            return false;
        }
        return true;

    }

}
