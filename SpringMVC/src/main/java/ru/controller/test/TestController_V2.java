package ru.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/testController")
public class TestController_V2 {

    /**
     * http://localhost:8081/testController/?carName=Bmw
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String getForm(@RequestParam("carName") String name, Model model){
        model.addAttribute("message", "Hello, this is car name from test controller: " + name.toUpperCase());
        return "processForm";
    }
}
