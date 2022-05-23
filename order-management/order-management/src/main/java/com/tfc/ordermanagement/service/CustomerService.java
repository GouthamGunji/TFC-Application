package com.tfc.ordermanagement.service;

import com.tfc.ordermanagement.model.Customer;
import com.tfc.ordermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String saveCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer details added Successfully";
    }
}
