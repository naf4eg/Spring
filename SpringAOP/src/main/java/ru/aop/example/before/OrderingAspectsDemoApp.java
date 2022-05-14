package ru.aop.example.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.before.configuration.DemoConfiguration;
import ru.aop.example.before.dao4.PersonDAO;

public class OrderingAspectsDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var bean1 = ctx.getBean(PersonDAO.class);
        bean1.findPerson();
    }
}
