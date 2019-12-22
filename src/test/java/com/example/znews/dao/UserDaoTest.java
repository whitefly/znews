package com.example.znews.dao;

import com.example.znews.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void findUser() {
        User one = new User("fuck232", "123", "thank", "www.hao123.com");
//        userDao.addUser(one);
//        userDao.delete(1);
        User userById = userDao.findUserById(3);
        Assert.assertEquals(Integer.valueOf(3), userById.getId());
        System.out.println(userById);
    }

    @Test
    public void addUser() {
        User one = new User("zhouang", "123", "good", "xingbao.site");
        userDao.insertUser(one);
    }


    @Test
    public void delete() {
        int id = 3;
        boolean result = userDao.deleteUserById(id);
        System.out.println(result);
    }

    @Test
    public void update() {
        int id = 4;
        User user = userDao.findUserById(id);
        user.setSalt("woshizhazha");
        userDao.updateUser(user);

    }
}