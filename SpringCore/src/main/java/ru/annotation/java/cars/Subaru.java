package ru.annotation.java.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.common.Car;
import ru.common.Color;
import ru.common.Engine;

@Component
public class Subaru implements Car {

    private Engine engine;

    @Autowired
    @Qualifier("sky")
    private Color color;

    @Autowired
    public void setEngine(@Qualifier("fa24f") Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getName() {
        return "Subaru";
    }

    @Override
    public String getEnginePower() {
        return engine.getPower();
    }

    @Override
    public String getColor() {
        return color.getColor();
    }
}
