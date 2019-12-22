package com.example.znews.dao;

import com.example.znews.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface UserDao {
    String TABLE_NAME = "user";
    String PROPERTY = "name,password,salt,head_url";


    User findUserById(@Param("id") int id);

    int insertUser(User user);

    boolean deleteUserById(int id);

    boolean updateUser(User user);


}
