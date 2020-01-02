package com.example.znews.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SensitiveWordsUtilTest {

    @Autowired
    private SensitiveWordsUtil sensitiveWordsUtil;

    @Test
    public void afterPropertiesSet() {
        sensitiveWordsUtil.afterPropertiesSet();
    }

    @Test
    public void filter() {
        String input1 = "我是习近平的大爷";
        Assert.assertEquals(String.format("我是%s的大爷", SensitiveWordsUtil.replaceWord), sensitiveWordsUtil.filter(input1));

        String input2 = "请问哪里可以找小姐";
        Assert.assertEquals(String.format("请问哪里可以%s", SensitiveWordsUtil.replaceWord), sensitiveWordsUtil.filter(input2));

        String input3 = "我是习近平的姐夫,我现在就想找小姐,越色情越好,就想爽一爽";
        Assert.assertEquals(String.format("我是%1$s的姐夫,我现在就想%1$s,越%1$s越好,就想爽一爽", SensitiveWordsUtil.replaceWord), sensitiveWordsUtil.filter(input3));

        String input4 = "我是习近  ^_^平的大爷";
        Assert.assertEquals(String.format("我是%s的大爷", SensitiveWordsUtil.replaceWord), sensitiveWordsUtil.filter(input4));
    }
}