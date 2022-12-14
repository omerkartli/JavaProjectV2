package com.example.javaprojectv2.service;

import com.example.javaprojectv2.model.Customer;
import com.example.javaprojectv2.repository.CustomerRepository;
import com.example.javaprojectv2.service.dto.CustomerInputDTO;
import com.example.javaprojectv2.service.dto.CustomerResultDTO;
import com.example.javaprojectv2.service.dto.LoginInputDTO;
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

    public CustomerResultDTO saveCustomer(CustomerInputDTO customerInputDTO) {
        Customer customer=new Customer();
        customer.setName(customerInputDTO.getName());
        customer.setSurname(customerInputDTO.getSurname());
        customer.setUsername(customerInputDTO.getUsername());
        customer.setPassword(customerInputDTO.getPassword());//maplame
        customer.setRole("Customer");

        customer = customerRepository.save(customer);

        CustomerResultDTO customerResultDTO=new CustomerResultDTO();
        customerResultDTO.setId(customer.getId());
        customerResultDTO.setName(customer.getName());
        customerResultDTO.setSurname(customer.getSurname());
        customerResultDTO.setUsername(customer.getUsername());
        customerResultDTO.setRole(customer.getRole());

        return customerResultDTO;
    }
    public CustomerResultDTO loginCustomer(LoginInputDTO loginInputDTO){
        Optional<Customer> customerControl = customerRepository.findFirstByUsernameAndUserpassword(loginInputDTO.getUsername(), loginInputDTO.getUserpassword());
        CustomerResultDTO customerResultDTO=new CustomerResultDTO();
        if (customerControl.isPresent()){

            customerResultDTO.setId(customerControl.get().getId());
            customerResultDTO.setName(customerControl.get().getName());
            customerResultDTO.setSurname(customerControl.get().getSurname());
            customerResultDTO.setUsername(customerControl.get().getUsername());
            customerResultDTO.setRole(customerControl.get().getRole());

        }
        return customerResultDTO;
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
