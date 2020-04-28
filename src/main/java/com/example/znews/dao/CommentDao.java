package com.example.znews.dao;

import com.example.znews.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CommentDao {


    Comment findCommentById(@Param("id") int id);

    int insertComment(Comment Comment);

    int deleteCommentById(int id, int status);

    boolean updateComment(Comment Comment);
    //关于哪个entity的回答
    List<Comment> findCommentsByEntity(int entityType, int entityId);

    List<Comment> findCommentsByEntities(int entityType,@Param("entityIds") List<Integer> entityIds);

    List<Comment> findCommentsByUserId(int userId,int entityType);




}
