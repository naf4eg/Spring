package ru.aop.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.configuration.DemoConfiguration;
import ru.aop.example.dao.AccountDAO;
import ru.aop.example.dao.MembershipDAO;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var bean1 = ctx.getBean("accountDAO", AccountDAO.class);
        var bean2 = ctx.getBean("membershipDAO", MembershipDAO.class);

        bean1.addAccount();
        bean2.addAccount();
        bean2.addAllAccounts();
        bean2.addAllAccountsToMongoDB();
        ctx.close();
    }
}
