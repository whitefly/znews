package com.example.znews.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUtilTest {

    @Test
    public void getRandomImageUrl() {
        for (int i = 0; i < 10; i++) {
            String imageUrl = UserUtil.getRandomImageUrl();
            System.out.println(imageUrl);
        }

    }
}