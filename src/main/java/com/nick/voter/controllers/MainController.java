package com.nick.voter.controllers;

import com.nick.voter.entity.Quiz;
import com.nick.voter.service.QuizService;
import com.nick.voter.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private QuizServiceImpl quizService;

    @RequestMapping("/")
    public String makeTheme(){
        Quiz quiz = new Quiz();
        quiz.setTheme("sss");
        quiz.setVotes(1);
        quizService.saveNewQuiz(quiz);

        return "main.html";
    }
}
