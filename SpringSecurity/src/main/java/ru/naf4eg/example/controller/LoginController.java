package ru.naf4eg.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    public static final String LOGIN_PAGE_URL = "/loginPage";
    public static final String ACCESS_DENIED_URL = "/access-denied";

    @RequestMapping(LOGIN_PAGE_URL)
    String getLoginPage() {
        return "fancy-login";
    }

    @RequestMapping(ACCESS_DENIED_URL)
    String getAccessDenied() {
        return "access-denied";
    }
}
