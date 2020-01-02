package com.example.znews.service;

import com.example.znews.model.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    public void getLatestQuestions() {
        List<Question> latestQuestions = questionService.getLatestQuestions();
        for (Question q : latestQuestions) {
            System.out.println(q);
        }
    }
}