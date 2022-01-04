package ru.annotation.java.cars;

import org.springframework.beans.factory.annotation.Value;
import ru.common.Car;
import ru.common.Engine;

public class LandRover implements Car {
    private Engine engine;

    @Value("${color.red}")
    private String color;

    public LandRover(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getName() {
        return "LandRover";
    }

    @Override
    public String getEnginePower() {
        return engine.getPower();
    }

    @Override
    public String getColor() {
        return color;
    }
}
