package com.example.javaprojectv2.service;

import com.example.javaprojectv2.model.Customer;
import com.example.javaprojectv2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Long updateCustomer(Customer customer, Long id){
        Customer referenceById = customerRepository.getReferenceById(id);
        referenceById.setUsername(customer.getUsername());
        Customer save = customerRepository.save(referenceById);
        return save.getId();
    }

    private static List<Customer> loadCustomersFromDb(){
        List<Customer>custObject=new ArrayList<Customer>();
        return custObject;
    }
    private List<Customer> customers=loadCustomersFromDb();
    List<Customer> getAllCustomers(){
        return customers;
    }
    public String updateCustomer(Customer customer) {
        boolean resourceFound =false;
        for(Customer currentCustomer: customers){
            if(currentCustomer.getId()==customer.getId()){
                resourceFound=true;
                currentCustomer.setName(customer.getName());
                currentCustomer.setSurname(customer.getSurname());
                currentCustomer.setUsername(customer.getUsername());
                currentCustomer.setPassword(customer.getPassword());
                currentCustomer.setRole(customer.getRole());
            }
            if(!resourceFound){
                customers.add(customer);
                return "Customer added";
            }
            return "Customer Updated Succesfully";
        }
        return null;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        List<Customer> customer = customerRepository.findAll();
        return customer;
    }
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            System.out.println(" Customer Not found");
        }
        return customer;
    }
    public void deleteCity(@PathVariable Long id) {
        customerRepository.deleteById(id);

    }
    public void deleteAllCustomer() {
        customerRepository.deleteAll();
    }
}
