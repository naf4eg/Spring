package ru.controller.car;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.controller.car.model.Car;
import ru.controller.car.model.Driver;

import javax.validation.Valid;

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
            @Valid @ModelAttribute(DRIVER) Driver theDriver, BindingResult theDriverBinding
    ) {
        System.out.println("theDriverBinding: " + theDriverBinding.hasErrors());
        System.out.println(theCar.getModelName() + " " + theCar.getColor());
        System.out.println(theDriver.getFirstName() + " " + theDriver.getLastName());
        return theDriverBinding.hasErrors() ? "car-registration-form" : "car-registered-form";
    }
}
