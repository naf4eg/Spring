package ru.aop.example.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println(getClass() + " ====> call membershipDAO addAccount() \n");
    }

    public void addAllAccounts() {
        System.out.println(getClass() + " ====> call membershipDAO addAllAccounts() \n");
    }

    public boolean addAllAccountsToMongoDB() {
        System.out.println(getClass() + " ====> call membershipDAO addAllAccountsToMongoDB \n");
        return true;
    }
}
