package ru.annotation.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.common.Car;

public class SpringAnnotationsApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
        Car car1 = ctx.getBean("honda", Car.class);
        Car car2 = ctx.getBean("subaru", Car.class);
        System.out.println(car1.getName());
        System.out.println("Engine: " + car1.getEnginePower());
        System.out.println("Color: " + car1.getColor());
        System.out.println("-----------------------------");
        System.out.println(car2.getName());
        System.out.println("Engine: " + car2.getEnginePower());
        System.out.println("Color: " + car2.getColor());
        System.out.println("-----------------------------");
    }
}
