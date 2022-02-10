package ru.controller.car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.controller.car.model.Car;
import ru.controller.car.model.Driver;

@Controller
@RequestMapping("/car")
public class CarController {
    private static final String CAR = "car";
    private static final String DRIVER = "driver";

    @RequestMapping("/showRegistrationForm")
    String showRegistrationForm(Model model){
        model.addAttribute(CAR, new Car());
        model.addAttribute(DRIVER, new Driver());
        return "car-registration-form";
    }

    @RequestMapping("/showRegisteredForm")
    String showRegisteredForm(
            @ModelAttribute(CAR) Car theCar,
            @ModelAttribute(DRIVER) Driver theDriver
    ) {
        System.out.println(theCar.getModelName() + " " + theCar.getColor());
        System.out.println(theDriver.getFirstName() + " " + theDriver.getLastName());
        return "car-registered-form";
    }
}
