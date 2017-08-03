package com.nick.voter.service;

import com.nick.voter.entity.Quiz;

public interface QuizService {

    long saveNewQuiz(Quiz quiz);

    Quiz getById(Long id);

    void startQuiz(Quiz quiz);

    void closeQuiz(Quiz quiz);

//    Long getQuizId(Quiz quiz);
}
