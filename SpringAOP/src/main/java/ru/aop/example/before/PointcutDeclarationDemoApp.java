package ru.aop.example.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.before.configuration.DemoConfiguration;
import ru.aop.example.before.dao2.CarsDAO;

public class PointcutDeclarationDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var bean1 = ctx.getBean(CarsDAO.class);

        bean1.visualizationCars();
    }
}
