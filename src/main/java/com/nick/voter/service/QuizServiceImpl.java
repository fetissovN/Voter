package com.nick.voter.service;

import com.nick.voter.dto.QuizDTO;
import com.nick.voter.dto.RemindRepository;
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
    public void saveNewQuiz(Quiz quiz) {
        repository.saveAndFlush(quiz);
    }

}
