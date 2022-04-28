package ru.aop.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.configuration.DemoConfiguration;
import ru.aop.example.dao5.EmployeeDAO;
import ru.aop.example.model.Employee;

public class JoinPointAspectDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var employeeDAO = ctx.getBean(EmployeeDAO.class);

        employeeDAO.setEmployee(new Employee("Alex", "Frolov"));
        var employee = employeeDAO.getEmployee();
        System.out.println(employee);
    }
}
