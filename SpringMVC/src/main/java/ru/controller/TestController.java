package ru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String getMainPage(){
        return "main-form";
    }

    @RequestMapping("/processForm")
    public String processForm() { return "processForm"; }
}
