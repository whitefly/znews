package com.example.znews.dao;

import com.example.znews.model.Question;
import com.example.znews.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface QuestionDao {
    String TABLE_NAME = "question";
    String PROPERTY = "title,content,create_date,user_id,comment_count";

    @Insert({"insert into ", TABLE_NAME, "(", PROPERTY, ") values(#{title},#{content},#{createDate},#{userId},#{commentCount})"})
    int addUser(Question q);


    //选出最新的问题
    Question findLastQuestions(@Param("userId") int useId,
                               @Param("offset") int offset,
                               @Param("limit") int limit
    );

    @Select({"select * from", TABLE_NAME, "where id=${id}"})
    User findUserById(@Param("id") int id);


    @Update({"update", TABLE_NAME, "set password=#{password} where id = #{id}"})
    void update(User user);

    @Delete({"Delete from", TABLE_NAME, "where id=#{id}"})
    void delete(int id);
}
