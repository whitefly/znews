package com.example.znews.service;

import com.example.znews.dao.UserDao;
import com.example.znews.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    public List<User> findUsersById(List<Integer> ids) {
        List<User> result = new ArrayList<>();
        if (ids == null) return result;

        for (int id : ids) {
            result.add(userDao.findUserById(id));
        }
        return result;

    }

}
