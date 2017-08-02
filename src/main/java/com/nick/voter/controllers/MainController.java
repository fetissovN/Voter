package com.nick.voter.controllers;

import com.nick.voter.entity.Quiz;
import com.nick.voter.service.QuizService;
import com.nick.voter.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private QuizServiceImpl quizService;

    @RequestMapping(value = "api/makeQuiz/{quiz}", method = RequestMethod.GET)
    @ResponseBody
    public String makeTheme(@PathVariable String quiz){
        System.out.println(quiz.toString());
        Quiz quizz = new Quiz();
        quizz.setTheme("sss");
        quizz.setVotes(1);
        quizService.saveNewQuiz(quizz);

        return "main.html";
    }
}
