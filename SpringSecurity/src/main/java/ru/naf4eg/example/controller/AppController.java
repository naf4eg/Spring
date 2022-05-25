package ru.naf4eg.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    public String getHomePage() {
        return "home";
    }
}
