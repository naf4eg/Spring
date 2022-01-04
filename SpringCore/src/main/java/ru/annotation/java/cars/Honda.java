package ru.annotation.java.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.common.Car;
import ru.common.Color;
import ru.common.Engine;

@Component("honda")
public class Honda implements Car {
    private Engine engine;

    @Autowired
    @Qualifier("black")
    private Color color;

    public Honda(@Autowired @Qualifier("h23") Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getName() {
        return "Honda";
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
