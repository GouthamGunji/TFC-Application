package com.tfc.ordermanagement.controller;

import com.tfc.ordermanagement.model.Customer;
import com.tfc.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
}
