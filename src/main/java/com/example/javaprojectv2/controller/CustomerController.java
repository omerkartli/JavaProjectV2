package com.example.javaprojectv2.controller;

import com.example.javaprojectv2.model.Customer;
import com.example.javaprojectv2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
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
    public String updateCustomer(@RequestBody Customer customer) {
        boolean resourceFound =false;
        for(Customer currentCustomer:getAllCustomer()){
            if(currentCustomer.getId()==customer.getId()){
                resourceFound=true;
                currentCustomer.setName(customer.getName());
                currentCustomer.setSurname(customer.getSurname());
                currentCustomer.setUsername(customer.getUsername());
                currentCustomer.setPassword(customer.getPassword());
                currentCustomer.setRole(customer.getRole());
            }
            return "Customer Updated Succesfully";
        }
        return null;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }
    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            System.out.println(" Customer Not found");
        }
        return customer;
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCity(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
    @DeleteMapping("/customers")
    public void deleteAllCustomer() {
        customerRepository.deleteAll();

    }

}
