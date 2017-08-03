package com.nick.voter.service;

import com.nick.voter.dao.RemindRepository;
import com.nick.voter.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

//    @Autowired
//    private QuizDTO quizDTO;

    @Autowired
    private RemindRepository repository;

    @Override
    public long saveNewQuiz(Quiz quiz) {
        Quiz newQuiz = repository.saveAndFlush(quiz);
        return newQuiz.getId();
    }

    @Override
    public Quiz getById(Long id) {
        return repository.findOne(id);
    }

//    @Override
//    public Long getQuizId(Quiz quiz) {
//        return repository.findOne();
//    }


}
