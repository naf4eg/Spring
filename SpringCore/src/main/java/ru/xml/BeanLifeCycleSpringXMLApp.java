package ru.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.common.Car;

public class BeanLifeCycleSpringXMLApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
        Car audi1 = ctx.getBean("audi", Car.class);
        System.out.println(audi1.getName() + "\nengine: " + audi1.getEnginePower() + "\ncolor: " + audi1.getColor());
        ctx.close();
    }
}
