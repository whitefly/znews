package com.example.znews.async;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventProducerTest {

    @Test
    public void produceEvent() {
        EventModel eventModel = new EventModel();

        eventModel.setActorId(1);
        eventModel.setEntityId(2);
        eventModel.setEntityType(3);
        eventModel.setEventType(EventType.COMMENT);
        eventModel.setEntityOwnerId(4);
        eventModel.setExt("name", "ang");
        String rnt = JSON.toJSONString(eventModel);
        System.out.println(rnt);
    }
}