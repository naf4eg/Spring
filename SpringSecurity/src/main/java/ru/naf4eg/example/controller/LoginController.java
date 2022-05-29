package ru.naf4eg.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    public static final String LOGIN_PAGE_URL = "/loginPage";

    @RequestMapping(LOGIN_PAGE_URL)
    String getLoginPage() {
        return "login-page";
    }
}
