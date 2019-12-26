package com.example.znews.service;

import com.example.znews.dao.QuestionDao;
import com.example.znews.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;


    public List<Question> getLatestQuestions() {
        return questionDao.findLatestQuestions(0, 1, 10);
    }
}
