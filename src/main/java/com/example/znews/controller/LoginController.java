package com.example.znews.controller;

import com.example.znews.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/register")
    public String registerUser(@RequestParam("account") String userName,
                               @RequestParam("password") String password, Model model) {
        Map<String, String> result = loginService.register(userName, password);
        if (result.containsKey("msg")) {
            //注册失败,注册页显示错误信息
            model.addAttribute("msg", result.get("msg"));
            return "login";
        } else {
            //注册成功,跳转到首页
            return "redirect:/";
        }
    }

    @PostMapping(path = "/login")
    public String login(@RequestParam("account") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("next") String next,
                        @RequestParam(value = "remember_me", defaultValue = "false") boolean rememberMe, HttpServletResponse response, Model model) {

        Map<String, String> map = loginService.login(userName, password);
        if (map.containsKey("ticket")) {
            //登录成功,并存储了session
            Cookie cookie = new Cookie("ticket", map.get("ticket"));
            cookie.setPath("/");
            response.addCookie(cookie);
            return StringUtils.isEmpty(next) ? "redirect:/" : "redirect:" + next;
        } else {
            //登录失败
            model.addAttribute("msg", map.get("msg"));
            return "login";
        }
    }

    @GetMapping(path = "/logout")
    public String logout(@CookieValue("ticket") String ticket) {
        loginService.logout(ticket);
        return "redirect:/";
    }


    @GetMapping(path = "/loginPage")
    public String loginPage(@RequestParam(value = "next", required = false) String next, Model model) {
        //hidden下next
        model.addAttribute("next", next);
        return "login";
    }


}
