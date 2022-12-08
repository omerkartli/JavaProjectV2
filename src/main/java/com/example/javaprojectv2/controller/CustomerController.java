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

/*    @PutMapping("/customers/{id}") /// yasbu
    public void updateCustomers(@RequestBody Customer customer, @PathVariable() Long id){
        customerService.updateCustomer(customer,id);
    }*/


/*  @PutMapping("/customers/{id}")
    public Customer mergeCustomer(@RequestBody Customer customer){

        return customerRepository.save(customer);
    }*/
    @PutMapping("/customers")
    public String updateCustomers(@RequestBody Customer customer) {
       return customerService.updateCustomer(customer);
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
    }
    @DeleteMapping("/customers")
    public void deleteAllCustomer() {

    }

}
