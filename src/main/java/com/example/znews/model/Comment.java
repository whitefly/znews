package com.example.znews.model;

import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private int userId;
    private Date createdDate;
    private int entityId;
    private int entityType;

    public int getEntityType() {
        return entityType;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    private int status;  // 比如评论可能处于删除状态

    public Comment() {
    }

    public int getId() {
        return id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", createdDate=" + createdDate +
                ", entityId=" + entityId +
                ", entity_type=" + entityType +
                ", status=" + status +
                '}';
    }
}
