package ru.aop.example.before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.before.configuration.DemoConfiguration;
import ru.aop.example.before.dao.AccountDAO;
import ru.aop.example.before.dao.MembershipDAO;
import ru.aop.example.before.model.Account;

public class PointcutExpressionDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        var bean1 = ctx.getBean("accountDAO", AccountDAO.class);
        var bean2 = ctx.getBean("membershipDAO", MembershipDAO.class);

        bean1.addAccount();
        bean1.addAccountWithParam(new Account());
        bean1.addAccountWithParam(new Account(), true);

        bean2.addAccount();
        bean2.addAllAccounts();
        bean2.addAllAccountsToMongoDB();
        ctx.close();
    }
}
