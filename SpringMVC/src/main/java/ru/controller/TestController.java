package ru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @RequestMapping("/")
    public String getMainPage() { return "main-page"; }

    @RequestMapping("/mainForm")
    public String getMainForm() { return "main-form"; }

    @RequestMapping("/processForm")
    public String processForm() { return "processForm"; }

    @RequestMapping("/processForm2")
    public String processForm_2(HttpServletRequest request, Model model) {
        String name = request.getParameter("carName");
        model.addAttribute("message","Congratulation, you are won the car " + name.toUpperCase());
        return "processForm";
    }
}
