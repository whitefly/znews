package com.example.znews.dao;

import com.example.znews.model.Feed;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface FeedDao {

    String TABLE_NAME = "feed";
    String INSERT_FIELDS = "user_id ,data,created_date,type";
    String SELECT_FIELDS = "id," + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME,
            "(", INSERT_FIELDS, ") values (#{userId},#{data},#{createdDate},#{type})"})
    int addFeed(Feed feed);


    //拉模式,直接取出关注用户,最新的feed信息
    List<Feed> selectUserFeeds(@Param("maxId") int maxId,
                               @Param("userIds") List<Integer> userIds,
                               @Param("count") int count);


    @Select({"select * from", TABLE_NAME, "where id=#{id}"})
    Feed findFeedById(@Param("id") int id);


}
