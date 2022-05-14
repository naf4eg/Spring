package ru.aop.example.after_returning.dao;

import org.springframework.stereotype.Component;
import ru.aop.example.after_returning.model.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private List<Account> accounts;

    public AccountDAO() {
        this.accounts = new ArrayList<>();
    }

    public void addAccounts(Account account) {
        if (this.accounts == null) this.accounts = new ArrayList<>();
        this.accounts.add(account);
    }

    public List<Account> findAccounts() {
        return this.accounts;
    }
}
