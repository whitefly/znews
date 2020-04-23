package com.example.znews.service;

import com.example.znews.dao.QuestionDao;
import com.example.znews.model.Question;
import com.example.znews.model.User;
import com.example.znews.utils.QuestionUtil;
import com.example.znews.utils.SensitiveWordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;


    @Autowired
    private SensitiveWordsUtil sensitiveWordsUtil;


    public List<Question> getLatestQuestions() {
        return questionDao.findLatestQuestions(0, 0, 10);
    }


    public Question getQuestionById(int id) {
        return questionDao.findQuestionById(id);
    }

    public List<Question> getQuestionByUser(User user) {
        return questionDao.findQuestionsByUserId(user.getId());
    }

    public boolean addQuestion(Question question) {
        //js字符转义
        question.setTitle(HtmlUtils.htmlEscape(question.getTitle()));
        question.setContent(HtmlUtils.htmlEscape(question.getContent()));
        //敏感词替换
        question.setTitle(sensitiveWordsUtil.filter(question.getTitle()));
        question.setContent(sensitiveWordsUtil.filter(question.getContent()));
        return questionDao.insertQuestion(question) > 0;
    }


}
