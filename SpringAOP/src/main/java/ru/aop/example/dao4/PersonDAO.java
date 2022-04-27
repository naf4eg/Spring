package ru.aop.example.dao4;

import org.springframework.stereotype.Component;

@Component
public class PersonDAO {

    public boolean findPerson() {
        System.out.println(getClass() + " DAO find Person...");
        return true;
    }
}
