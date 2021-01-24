package com.bcci.cricketscoreboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {


    @RequestMapping("/")
    public String viewHomePage(Model model) {

        return "index";
    }

}

