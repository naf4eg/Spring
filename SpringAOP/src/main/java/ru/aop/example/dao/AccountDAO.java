package ru.aop.example.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " ====> call AccountDAO \n");
    }
}
