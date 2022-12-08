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

    public Customer updateCustomer(Customer customer, Long id) {
        Optional<Customer> currentCustomer = getCustomer(id);
        if (currentCustomer.isPresent()) {
            currentCustomer.get().setName(customer.getName());
            currentCustomer.get().setSurname(customer.getSurname());
            currentCustomer.get().setUsername(customer.getUsername());
            currentCustomer.get().setPassword(customer.getPassword());
            currentCustomer.get().setRole(customer.getRole());
            return customerRepository.save(currentCustomer.get());
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

    public void deleteCity(Long id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllCustomer() {
        customerRepository.deleteAll();
    }

}
