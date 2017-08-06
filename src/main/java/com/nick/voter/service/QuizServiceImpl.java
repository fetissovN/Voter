package com.nick.voter.service;

import com.nick.voter.dao.RemindRepository;
import com.nick.voter.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

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

    @Override
    public void startQuiz(Quiz quiz) {
        quiz.setStarted(1);
        repository.save(quiz);
    }

    @Override
    public void closeQuiz(Quiz quiz) {
        quiz.setClosed(1);
        repository.save(quiz);
    }

    @Override
    public void assertQuiz(Quiz quiz) {
        quiz.setVotes(quiz.getVotes()+1);
        repository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return repository.findAll();
    }
}
