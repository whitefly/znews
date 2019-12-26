package com.example.znews.model;

import java.util.HashMap;
import java.util.Map;

public class ViewObject {
    private Map<String, Object> map = new HashMap<>();


    public Object getItem(String key) {
        return map.get(key);
    }

    public void putItem(String key, Object value) {
        map.put(key, value);
    }
}
