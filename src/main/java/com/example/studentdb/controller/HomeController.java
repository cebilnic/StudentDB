package com.example.studentdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value="/")
    public String showHomePage(){
        return "index";
    }
}
