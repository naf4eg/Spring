package ru.webapp.service;

import ru.webapp.entity.Customer;

import java.util.List;

/**
 * Customer Service
 */
public interface CustomerService {

    /**
     * Get all customers
     * @return list customers
     */
    List<Customer> getCustomers();

    /**
     * Save Customer object
     * @param theCustomer
     */
    void saveCustomer(Customer theCustomer);
}
