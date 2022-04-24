package ru.aop.example.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " ===>  addAccount to DB");
    }
}
