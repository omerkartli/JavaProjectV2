package com.example.javaprojectv2.controller;

import com.example.javaprojectv2.model.Customer;
import com.example.javaprojectv2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

  
    @Autowired
    CustomerService customerService;

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable() Long id) {
        return customerService.updateCustomer(customer, id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {

        return customerService.getAllCustomer();
    }
    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {

        return customerService.getCustomer(id);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCity(@PathVariable Long id) {
        customerService.deleteCity(id);
    }
    @DeleteMapping("/customers")
    public void deleteAllCustomer() {
        customerService.deleteAllCustomer();

    }

}
