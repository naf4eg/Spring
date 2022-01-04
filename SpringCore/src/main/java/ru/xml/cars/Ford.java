package ru.xml.cars;

import ru.common.Car;
import ru.common.Engine;

public class Ford implements Car {
    private Engine engine;
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public Ford(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getName() {
        return "Ford";
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
