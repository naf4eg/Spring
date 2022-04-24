package ru.aop.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.configuration.DemoConfiguration;
import ru.aop.example.dao.AccountDAO;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var bean = ctx.getBean("accountDAO", AccountDAO.class);
        bean.addAccount();
        ctx.close();
    }
}
