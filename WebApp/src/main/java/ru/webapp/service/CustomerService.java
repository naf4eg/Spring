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

    /**
     * get Customer
     * @param id id from DB
     * @return Customer ID
     */
    Customer getCustomer(int id);

    /**
     * Delete Customer from DB
     * @param id Customer ID
     */
    void deleteCustomer(int id);
}
