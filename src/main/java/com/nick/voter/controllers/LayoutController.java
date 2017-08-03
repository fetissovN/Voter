package com.nick.voter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class LayoutController {
    @RequestMapping("/")
    public String main(){
        return "index";
    }
}
