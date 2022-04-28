package ru.aop.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.configuration.DemoConfiguration;
import ru.aop.example.dao5.EmployeeDAO;

public class JoinPointAspectDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var employee = ctx.getBean(EmployeeDAO.class);
        employee.setName("OLOLO");
        employee.getName();
    }
}
