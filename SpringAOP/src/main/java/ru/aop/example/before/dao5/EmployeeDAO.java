package ru.aop.example.before.dao5;

import org.springframework.stereotype.Component;
import ru.aop.example.before.model.Employee;

@Component
public class EmployeeDAO {

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
