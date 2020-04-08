package com.example.znews.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.HashMap;
import java.util.Map;

public class QuestionUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    static public String getCodeJson(int code, String msg) {

        ObjectNode node = mapper.createObjectNode();
        node.put("code", code);
        node.put("msg", msg);
        return node.toString();
    }

    static public String getCodeJson(int code) {
        ObjectNode node = mapper.createObjectNode();
        node.put("code", code);
        return node.toString();
    }


    public static void main(String[] args) {
        System.out.println(getCodeJson(0, "wtf?"));
    }

}
