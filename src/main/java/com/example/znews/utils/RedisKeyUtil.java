package com.example.znews.utils;

public class RedisKeyUtil {
    private static String SplitTag = "_";
    private static String Like = "LIKE";
    private static String DisLike = "DISLIKE";


    public static String getLikeKey(int entityType, int entityID) {
        // 生成某个回答赞同的唯一id
        return Like + SplitTag + String.valueOf(entityType) + SplitTag + String.valueOf(entityID);
    }

    public static String getDisLikeKey(int entityType, int entityID) {
        // 生成某个回答赞同的唯一id
        return DisLike + SplitTag + String.valueOf(entityType) + SplitTag + String.valueOf(entityID);
    }


}
