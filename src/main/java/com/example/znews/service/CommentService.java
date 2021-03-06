package com.example.znews.service;

import com.example.znews.dao.CommentDao;
import com.example.znews.dao.QuestionDao;
import com.example.znews.model.Comment;
import com.example.znews.model.EntityType;
import com.example.znews.model.Question;
import com.example.znews.model.User;
import com.example.znews.utils.SensitiveWordsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private SensitiveWordsUtil sensitiveWordsUtil;

    public boolean deleteComment(int id) {
        return commentDao.deleteCommentById(id, -1) > 0;
    }

    public int addComment(Comment comment) {
        //任何评论内容都需要加过滤
        String content = comment.getContent();
        content = HtmlUtils.htmlEscape(content);
        content = sensitiveWordsUtil.filter(content);
        comment.setContent(content);

        //增加该问题的评论数量
        if (comment.getEntityType() == EntityType.ENTITY_QUESTION) {
            questionDao.plusCommentCount(comment.getEntityId());
        }
        return commentDao.insertComment(comment);
    }

    public List<Comment> getCommentByQuestion(Question question) {
        return commentDao.findCommentsByEntity(EntityType.ENTITY_QUESTION, question.getId());
    }

    public Comment getCommentById(int id) {
        return commentDao.findCommentById(id);
    }

    public List<Comment> getAnswersByUser(User user) {
        return commentDao.findCommentsByUserId(user.getId(), EntityType.ENTITY_QUESTION);
    }

    public List<Comment> getAnswersByEntities(List<Integer> questionsId) {
        if (questionsId == null || questionsId.size() == 0) return new ArrayList<>();
        return commentDao.findCommentsByEntities(EntityType.ENTITY_QUESTION, questionsId);
    }


}
