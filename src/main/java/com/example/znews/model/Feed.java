package com.example.znews.model;

import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.Map;

public class Feed {
    private int id;
    private int type;  //点赞的新鲜事,发文章的新鲜事,评论的新鲜事
    private int userId;  //谁产生的新鲜事
    private Date createdDate; //新鲜事产生的时间点
    private String data;
    private Map json;

    public Feed() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
        json = JSON.toJavaObject(JSON.parseObject(data), Map.class);
    }

    public Map getJson() {
        return json;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "id=" + id +
                ", type=" + type +
                ", userId=" + userId +
                ", createdDate=" + createdDate +
                ", data='" + data + '\'' +
                '}';
    }
}
