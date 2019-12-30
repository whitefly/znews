package com.example.znews.model;

import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<>();


    /*
    由拦截器在请求发送过来时,将登陆状态的用户对象分配到对应的线程中
     */

    public User getUser() {
        //预期在controller中获取
        return users.get();
    }

    public void setUsers(User user) {
        //预期在拦截器中获取
        users.set(user);
    }

    public void clear() {
        //在一次请求完成后,删除这个user变量
        users.remove();
    }
}
