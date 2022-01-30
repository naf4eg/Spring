package ru.controller.car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.controller.car.model.Car;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/showRegistrationForm")
    String showRegistrationForm(Model model){
        model.addAttribute("car", new Car());
        return "car-registration-form";
    }

    @RequestMapping("/showRegisteredForm")
    String showRegisteredForm(@ModelAttribute("car") Car theCar) {
        System.out.println(theCar.getModelName() + " " + theCar.getColor());
        return "car-registered-form";
    }
}
