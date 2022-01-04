package ru.annotation.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.annotation.java.config.SpringCarConfiguration;
import ru.common.Car;

public class SpringConfigWithJavaCodeApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringCarConfiguration.class);
        Car car1 = ctx.getBean("honda", Car.class);
        Car car2 = ctx.getBean("subaru", Car.class);
        Car car3 = ctx.getBean("landRover", Car.class);

        System.out.println(car1.getName());
        System.out.println("Engine: " + car1.getEnginePower());
        System.out.println("Color: " + car1.getColor());
        System.out.println("-----------------------------");
        System.out.println(car2.getName());
        System.out.println("Engine: " + car2.getEnginePower());
        System.out.println("Color: " + car2.getColor());
        System.out.println("-----------------------------");
        System.out.println(car3.getName());
        System.out.println("Engine: " + car3.getEnginePower());
        System.out.println("Color: " + car3.getColor());
        System.out.println("-----------------------------");
    }
}
