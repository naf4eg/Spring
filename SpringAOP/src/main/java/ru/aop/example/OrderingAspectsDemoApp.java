package ru.aop.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.configuration.DemoConfiguration;
import ru.aop.example.dao4.PersonDAO;

public class OrderingAspectsDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var bean1 = ctx.getBean(PersonDAO.class);
        bean1.findPerson();
    }
}
