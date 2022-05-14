package ru.aop.example.after_returning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aop.example.after_returning.configuration.AfterReturningConfiguration;
import ru.aop.example.after_returning.dao.AccountDAO;
import ru.aop.example.after_returning.model.Account;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AfterReturningConfiguration.class);
        var accountDao = ctx.getBean(AccountDAO.class);
        accountDao.addAccounts(new Account("12344321", Account.Type.ACCOUNT));
        accountDao.addAccounts(new Account("5678998765", Account.Type.CARD));
        accountDao.addAccounts(new Account("0192834756", Account.Type.DEPOSIT));

        accountDao.findAccounts();

        ctx.close();
    }
}
