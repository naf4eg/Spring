package ru.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.common.Car;

public class BeanScopeSpringXMLApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
        Car audi1 = ctx.getBean("audi", Car.class);
        Car audi2 = ctx.getBean("audi", Car.class);
        System.out.println(audi1.getName() + "\nengine: " + audi1.getEnginePower() + "\ncolor: " + audi1.getColor());
        System.out.println("-----------------------------");
        System.out.println(audi2.getName() + "\nengine: " + audi2.getEnginePower() + "\ncolor: " + audi2.getColor());
        boolean resultCompare = audi1 == audi2;
        System.out.println("-----------------------------");
        System.out.println("Compare Result: " + resultCompare);
        System.out.println("-----------------------------");
        System.out.println("memory bean1: " + audi1);
        System.out.println("-----------------------------");
        System.out.println("memory bean2: " + audi2);
        ctx.close();
    }
}
