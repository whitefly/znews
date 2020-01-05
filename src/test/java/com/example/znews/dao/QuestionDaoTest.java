package com.example.znews.dao;

import com.example.znews.model.Question;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionDaoTest {

    @Autowired
    private QuestionDao questionDao;

    @Test
    public void findQuestionById() {

    }

    @Test
    public void insertQuestion() {
        for (int i = 0; i < 10; i++) {
            Question item = new Question();
            item.setTitle("超级无敌难的问题:" + i + "?");
            item.setContent("宇宙的起源哦");
            item.setUserId(4);
            item.setCreatedDate(new Date());
            item.setCommentCount(1);
            questionDao.insertQuestion(item);
        }
    }

    @Test
    public void deleteQuestionById() {
    }

    @Test
    public void updateQuestion() {
        Question item = questionDao.findQuestionById(3);
        item.setTitle("十万个为什么?");
        questionDao.updateQuestion(item);

    }

    @Test
    public void findLatestQuestions() {
        List<Question> result = questionDao.findLatestQuestions(0, 1, 10);

        System.out.println(result);
    }

    @Test
    public void plusCommentCount() {
        int id = 13;
        Assert.assertEquals(1, questionDao.plusCommentCount(id));

    }
}