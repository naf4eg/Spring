package ru.aop.example.before.dao2;

import org.springframework.stereotype.Component;

@Component
public class CarsDAO {

    public void visualizationCars() {
        System.out.println(getClass() + " ====> call  addCar() \n");
    }
}
