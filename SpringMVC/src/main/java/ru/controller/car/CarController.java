package ru.controller.car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/showForm")
    String showForm(Model model){
        model.addAttribute("car", new Car());
        return "car-form";
    }
}
