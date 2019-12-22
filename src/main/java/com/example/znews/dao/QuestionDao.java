package com.example.znews.dao;

import com.example.znews.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionDao {


    Question findQuestionById(@Param("id") int id);

    int insertQuestion(Question question);

    boolean deleteQuestionById(int id);

    boolean updateQuestion(Question question);

    /*
    显示每页的问题
     */
    List<Question> findLatestQuestions(@Param("userId") int useId,
                                       @Param("offset") int offset,
                                       @Param("limit") int limit);


}
