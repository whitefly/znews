package com.example.znews.utils;

public class RedisKeyUtil {
    private static String SplitTag = "_";
    private static String LikeKey = "LIKE";
    private static String DisLikeKey = "DISLIKE";

    private static String EventQueueKey = "Event_Queue_Key";

    private static String FollowerKey = "Follower_Key";
    private static String FolloweeKey = "Followee_Key";


    public static String getLikeKey(int entityType, int entityID) {
        // 生成某个回答赞同的唯一id
        return LikeKey + SplitTag + String.valueOf(entityType) + SplitTag + String.valueOf(entityID);
    }

    public static String getDisLikeKey(int entityType, int entityID) {
        // 生成某个回答赞同的唯一id
        return DisLikeKey + SplitTag + String.valueOf(entityType) + SplitTag + String.valueOf(entityID);
    }

    public static String getEventQueueKey() {
        return EventQueueKey;
    }

    public static String getFollowerKey(int entityType, int entityId) {
        //实体(可以是问题,用户)的所有关注者
        return FollowerKey + SplitTag + entityType + SplitTag + entityId;
    }

    public static String getFolloweeKey(int userId, int entityType) {
        //用户的关注列表
        return FolloweeKey + SplitTag + userId + SplitTag + entityType;
    }
}
