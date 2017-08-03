package com.nick.voter.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nick.voter.entity.Quiz;
import com.nick.voter.service.QuizService;
import com.nick.voter.service.QuizServiceImpl;
import com.nick.voter.util.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class MainController {
    public static final String HOST = "http://localhost:8077";

    @Autowired
    private QuizServiceImpl quizService;

    @RequestMapping(value = "api/makeQuiz/{quiz}", method = RequestMethod.GET)
    @ResponseBody
    public String makeTheme(@PathVariable String quiz){
        Quiz quizNew = null;
        try {
            quizNew = JsonParser.parseJsonStrToObject(quiz);
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        Long id = quizService.saveNewQuiz(quizNew);
        return HOST + "/api/get/"+id;
    }

    @RequestMapping(value = "api/get/{quizId}", method = RequestMethod.GET)
    @ResponseBody
    public String getQuizURL(@PathVariable int quizId){
        String json = null;
        try {
            Quiz quiz = quizService.getById((long) quizId);
            json = JsonParser.objectToStringJson(quiz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "fail";
        }
        return json;
    }

}
