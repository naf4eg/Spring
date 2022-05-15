package ru.aop.example.after;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.after.configuration.AfterReturningConfiguration;
import ru.aop.example.after.dao.AccountDAO;

public class AfterThrowDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AfterReturningConfiguration.class);
        var accountDao = ctx.getBean(AccountDAO.class);
        try {
            accountDao.findAccounts();
        } catch (Exception exception) {
            System.out.println("Error on DAO");
        }
    }
}
