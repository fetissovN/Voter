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
import java.util.List;

@Controller
public class RestController {
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
    public Quiz getQuizURL(@PathVariable int quizId){
        Quiz quiz = quizService.getById((long) quizId);
        if (quiz==null){
            return null;
        }
        return quiz;
    }

    @RequestMapping(value = "api/start/{quizId}", method = RequestMethod.GET)
    @ResponseBody
    public String startQuiz(@PathVariable int quizId){
        Quiz quiz = quizService.getById((long) quizId);
        if (quiz.getClosed()==1){
            return JsonParser.makeStatus("is closed");
        }else if (quiz.getStarted()==1){
            return JsonParser.makeStatus("already started");
        }
        quizService.startQuiz(quiz);
        return HOST + "/api/get/"+quiz.getId();
    }

    @RequestMapping(value = "api/close/{quizId}", method = RequestMethod.GET)
    @ResponseBody
    public String closeQuiz(@PathVariable int quizId){
        Quiz quiz = quizService.getById((long) quizId);
        if (quiz.getClosed()==1){
            return JsonParser.makeStatus("already closed");
        }else if (quiz.getStarted()==0){
            return JsonParser.makeStatus("not started");
        }
        quizService.closeQuiz(quiz);
        return JsonParser.makeStatus("success");
    }

    @RequestMapping(value = "api/quiz/assert/{quizId}", method = RequestMethod.GET)
    @ResponseBody
    public String assertQuiz(@PathVariable int quizId) {
        Quiz quiz = quizService.getById((long) quizId);
        if (quiz.getClosed()==0 && quiz.getStarted()==1){
            quizService.assertQuiz(quiz);
            return JsonParser.makeStatus("success");
        }else {
            return JsonParser.makeStatus("is closed or not started");
        }
    }

    @RequestMapping(value = "api/get/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Quiz> listQuiz() {
        return quizService.getAllQuiz();
    }

}

