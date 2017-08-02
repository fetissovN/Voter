package com.nick.voter.dto;

import com.nick.voter.entity.Quiz;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository("quizDTOImpl")
@Transactional
public class QuizDTOImpl implements QuizDTO {

    private final Logger LOGGER = Logger.getLogger(getClass());

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    public void saveNewQuiz(Quiz quiz) {
        sessionFactory.getCurrentSession().save(quiz);
    }
}
