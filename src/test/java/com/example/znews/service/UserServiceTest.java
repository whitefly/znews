package com.example.znews.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UserServiceTest {

    static class Person {
        private String name;
        private int age;
        private String hobbit;

        public Person(String name, int age, String hobbit) {
            this.name = name;
            this.age = age;
            this.hobbit = hobbit;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", hobbit='" + hobbit + '\'' +
                    '}';
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void demo() {
        userService.demo();
    }


    @Test
    public void demoOfAssert() {
        int num = 1;
        int[] nums = {1, 2, 3};
        String content = "周昂";

        Assert.assertEquals(num, 1);
        Assert.assertArrayEquals(nums, new int[]{1, 2, 3});
        Assert.assertEquals(content,"周昂");


    }
}