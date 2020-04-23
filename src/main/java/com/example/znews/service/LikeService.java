package com.example.znews.service;

import com.example.znews.model.User;
import com.example.znews.utils.RedisAdapter;
import com.example.znews.utils.RedisKeyUtil;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    /*
    该类用于专门的点赞系统
     */
    private static final Logger logger = LoggerFactory.getLogger(LikeService.class);

    @Autowired
    private RedisAdapter redisAdapter;


    public long like(int entityType, int entityID, int userId) {
        //将点赞的用户加入到redis对应的set中

        //添加喜欢
        String likeEntityKey = RedisKeyUtil.getLikeKey(entityType, entityID);
        Long aLong = redisAdapter.sAdd(likeEntityKey, String.valueOf(userId));
        if (aLong == 0) {
            //用户点赞已经存在于列表中,表示表示取消点赞
            redisAdapter.sRemove(likeEntityKey, String.valueOf(userId));
        } else {
            //首次点赞,删除不喜欢
            String dislikeEntityKey = RedisKeyUtil.getDisLikeKey(entityType, entityID);
            redisAdapter.sRemove(dislikeEntityKey, String.valueOf(userId));
        }
        return redisAdapter.sSize(likeEntityKey);
    }

    public long dislike(int entityType, int entityID, int userId) {
        //删除喜欢
        String likeEntityKey = RedisKeyUtil.getLikeKey(entityType, entityID);
        redisAdapter.sRemove(likeEntityKey, String.valueOf(userId));
        //添加不喜欢
        String dislikeEntityKey = RedisKeyUtil.getDisLikeKey(entityType, entityID);
        redisAdapter.sAdd(dislikeEntityKey, String.valueOf(userId));
        return redisAdapter.sSize(dislikeEntityKey);
    }

    public int getLikeStatus(int entityType, int entityID, int userId) {
        //查询用户对这个entity的喜欢状态
        //0:中立 1:喜欢 -1:不喜欢

        String likeEntityKey = RedisKeyUtil.getLikeKey(entityType, entityID);
        boolean isLIke = redisAdapter.isMember(likeEntityKey, String.valueOf(userId));
        if (isLIke) {
            return 1;
        }
        String dislikeEntityKey = RedisKeyUtil.getDisLikeKey(entityType, entityID);
        boolean disLike = redisAdapter.isMember(dislikeEntityKey, String.valueOf(userId));
        return disLike ? -1 : 0;
    }

    public long getLikeCount(int entityType, int entityID) {
        String likeEntityKey = RedisKeyUtil.getLikeKey(entityType, entityID);
        return redisAdapter.sSize(likeEntityKey);
    }
}
