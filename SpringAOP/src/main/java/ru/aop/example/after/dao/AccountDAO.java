package ru.aop.example.after.dao;

import org.springframework.stereotype.Component;
import ru.aop.example.after.model.Account;

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

    public List<Account> findAccounts() throws RuntimeException{
        if (this.accounts.isEmpty()) throw new RuntimeException();
        return this.accounts;
    }
}
