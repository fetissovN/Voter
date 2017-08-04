package com.nick.voter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {
    @RequestMapping("/")
    public String main(){
        return "index";
    }
    @RequestMapping("/quiz/{id}")
    public String quizLook(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        return "quiz";
    }
}
