package com.example.znews.async;

import java.util.HashMap;
import java.util.Map;

public class EventModel {

    private EventType eventType;

    private int entityType;
    private int entityId;

    private int actorId; //触发人的id
    private int entityOwnerId;


    private Map<String, String> extents = new HashMap<>();

    public EventModel() {
    }

    public EventModel(EventType eventType) {
        this.eventType = eventType;
    }

    public EventModel setExt(String k, String v) {
        extents.put(k, v);
        return this;
    }

    public String getExt(String k) {
        return extents.get(k);
    }

    public Map<String, String> getExtents() {
        return extents;
    }

    public void setExtents(Map<String, String> extents) {
        this.extents = extents;
    }

    public EventType getEventType() {
        return eventType;
    }

    public EventModel setEventType(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public EventModel setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public EventModel setEntityId(int entityId) {
        this.entityId = entityId;
        return this;

    }

    public int getActorId() {
        return actorId;
    }

    public EventModel setActorId(int actorId) {
        this.actorId = actorId;
        return this;
    }

    public int getEntityOwnerId() {
        return entityOwnerId;
    }

    public EventModel setEntityOwnerId(int entityOwnerId) {
        this.entityOwnerId = entityOwnerId;
        return this;
    }


}
