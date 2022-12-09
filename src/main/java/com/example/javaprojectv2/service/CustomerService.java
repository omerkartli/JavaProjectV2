package com.example.javaprojectv2.service;

import com.example.javaprojectv2.model.Customer;
import com.example.javaprojectv2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer updateCustomer, Long id) {
        Optional<Customer> currentCustomer = getCustomer(id);
        if (currentCustomer.isPresent()) {
            Customer customer = currentCustomer.get();
            customer.setName(updateCustomer.getName());
            customer.setSurname(updateCustomer.getSurname());
            customer.setUsername(updateCustomer.getUsername());
            customer.setPassword(updateCustomer.getPassword());
            customer.setRole(updateCustomer.getRole());
            return customerRepository.save(customer);
        }
        return null;
    }

    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Optional<Customer> getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            System.out.println(" Customer Not found");
        }
        return customer;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllCustomer() {
        customerRepository.deleteAll();
    }

}
