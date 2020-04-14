package com.example.znews.utils;

import com.alibaba.fastjson.JSON;
import com.example.znews.async.EventModel;
import org.junit.Test;

public class simpleTest {
    @Test
    public void test() {
        EventModel eventModel = new EventModel();
        eventModel.setExt("k", "v");
        String rnt = JSON.toJSONString(eventModel);
        System.out.println(rnt);
    }
}
