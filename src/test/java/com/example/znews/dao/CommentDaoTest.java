package com.example.znews.dao;

import com.example.znews.model.Comment;
import com.example.znews.model.EntityType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Test
    public void findCommentById() {
        Comment item = commentDao.findCommentById(2);
        System.out.println(item);
    }

    @Test
    public void insertComment() {
        for (int i = 0; i < 5; i++) {
            Comment comment = new Comment();
            comment.setUserId(3);
            comment.setContent(i + "天之后过来答题");
            comment.setCreatedDate(new Date());
            comment.setEntityType(2);
            comment.setEntityId(21);
            comment.setStatus(0);
            commentDao.insertComment(comment);
        }
    }

    @Test
    public void deleteCommentById() {

        commentDao.deleteCommentById(4, -1);
    }

    @Test
    public void updateComment() {
    }

    @Test
    public void findCommentsByEntity() {
        int type = 2;
        int id = 21;
        List<Comment> commentsByEntity = commentDao.findCommentsByEntity(type, id);
        System.out.println(commentsByEntity);
    }

    @Test
    public void findCommentsByUserId() {
        int userId=51;
        int entityType= EntityType.ENTITY_QUESTION;
        List<Comment> result = commentDao.findCommentsByUserId(userId, entityType);
        Assert.assertEquals(1,result.size());
    }
}