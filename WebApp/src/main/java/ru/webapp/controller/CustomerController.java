package ru.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.webapp.entity.Customer;
import ru.webapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private final static String CUSTOMERS = "customers";
    private final static String CUSTOMER = "customer";

    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    String getCustomers(Model model) {
        log.info("calling customers list.....");
        var customers = customerService.getCustomers();
        model.addAttribute(CUSTOMERS, customers);
        return "list-customers";
    }

    @GetMapping("/addCustomerForm")
    String getCustomerForm(Model model) {
        model.addAttribute(CUSTOMER, new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    String saveCustomer(@ModelAttribute(CUSTOMER) Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
}
