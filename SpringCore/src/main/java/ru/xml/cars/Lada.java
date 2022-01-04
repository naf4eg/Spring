package ru.xml.cars;

import ru.common.Car;
import ru.common.Engine;

public class Lada implements Car {

    private Engine engine;
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getName() {
        return "Lada";
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
