package ru.aop.example.dao5;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
