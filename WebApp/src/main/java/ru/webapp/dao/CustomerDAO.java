package ru.webapp.dao;

import ru.webapp.entity.Customer;
import java.util.List;

/**
 * Customers DAO
 */
public interface CustomerDAO {

    /**
     * DAO get method
     * @return List Customers
     */
    public List<Customer> getCustomers();
}
