package ru.aop.example.dao;

import org.springframework.stereotype.Component;
import ru.aop.example.model.Account;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " ====> call addAccount() \n");
    }

    public void addAccountWithParam(Account account) {
        System.out.println(getClass() + " ====> call  addAccountWithParam(Account account) \n");
    }

    public void addAccountWithParam(Account account, boolean isVIP) {
        System.out.println(getClass() + " ====> call  addAccountWithParam(Account account, boolean isVIP) \n");
    }
}
