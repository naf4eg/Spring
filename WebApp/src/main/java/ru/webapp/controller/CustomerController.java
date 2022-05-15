package ru.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.webapp.entity.Customer;
import ru.webapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private final static String CUSTOMERS = "customers";
    private final static String CUSTOMER = "customer";

    private final static String CUSTOMER_FORM = "customer-form";
    private final static String CUSTOMERS_LIST = "list-customers";

    @Autowired private CustomerService customerService;

    @GetMapping("list")
    String getCustomers(Model model) {
        var customers = customerService.getCustomers();
        model.addAttribute(CUSTOMERS, customers);
        return CUSTOMERS_LIST;
    }

    @GetMapping("/addCustomerForm")
    String getCustomerForm(Model model) {
        model.addAttribute(CUSTOMER, new Customer());
        return CUSTOMER_FORM;
    }

    @PostMapping("/saveCustomer")
    String saveCustomer(@ModelAttribute(CUSTOMER) Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/updateCustomerForm")
    String getCustomer(@RequestParam("customerId") int id, Model model) {
        var customer = customerService.getCustomer(id);
        model.addAttribute(CUSTOMER, customer);
        return CUSTOMER_FORM;
    }

    @GetMapping("/deleteCustomer")
    String deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
