package ru.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.webapp.dao.CustomerDAO;
import ru.webapp.entity.Customer;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private final static String CUSTOMERS = "customers";

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("list")
    String getCustomers(Model model){
        log.info("calling customers list.....");
        var customers = customerDAO.getCustomers();
        model.addAttribute(CUSTOMERS, customers);
        return "list-customers";
    }
}
