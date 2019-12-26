package com.example.znews.service;

import com.example.znews.dao.UserDao;
import com.example.znews.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

}
