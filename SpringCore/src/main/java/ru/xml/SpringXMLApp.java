package ru.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.common.Car;

public class SpringXMLApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car audi = ctx.getBean("audi", Car.class);
        System.out.println(audi.getName() + "\nengine: " + audi.getEnginePower() + "\ncolor: " + audi.getColor());

        System.out.println("-----------------------------");

        Car ford = ctx.getBean("ford", Car.class);
        System.out.println(ford.getName() + "\nengine: " + ford.getEnginePower() + "\ncolor: " + ford.getColor());

        System.out.println("-----------------------------");

        Car lada = ctx.getBean("lada", Car.class);
        System.out.println(lada.getName() + "\nengine: " + lada.getEnginePower() + "\ncolor: " + lada.getColor());
        ctx.close();
    }
}
