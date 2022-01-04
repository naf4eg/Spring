package ru.xml.cars;

import ru.common.Car;
import ru.common.Engine;

public class Audi implements Car {
    private Engine engine;
    private String color;

    @Override
    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public Audi(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String getName() {
        return "Audi";
    }

    @Override
    public String getEnginePower() {
        return engine.getPower();
    }

    public void doInitMethod(){
        System.out.println("Init method: " + this.getClass().getName());
    }

    public void doDestroyMethod(){
        //For "prototype" scoped beans, Spring does not call the destroy method.  Gasp!
        System.out.println("Destroy method: " + this.getClass().getName());
    }
}
