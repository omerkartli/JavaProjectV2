package com.example.javaprojectv2.controller;

import com.example.javaprojectv2.service.CustomerService;
import com.example.javaprojectv2.service.dto.CustomerInputDTO;
import com.example.javaprojectv2.service.dto.CustomerResultDTO;
import com.example.javaprojectv2.service.dto.LoginInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customers")
    public CustomerResultDTO saveCustomer(@RequestBody CustomerInputDTO customerInputDTO) {
        return customerService.saveCustomer(customerInputDTO);
    }

    @PostMapping("/customers/login")
    public CustomerResultDTO loginCustomer(@RequestBody LoginInputDTO loginInputDTO) {
        return customerService.loginCustomer(loginInputDTO);
    }

    @PutMapping("/customers/{id}")
    public CustomerResultDTO updateCustomer(@RequestBody CustomerInputDTO customerInputDTO, @PathVariable() Long id) {
        return customerService.updateCustomer(customerInputDTO, id);
    }

    @GetMapping("/customers")
    public List<CustomerResultDTO> getAllCustomer() {

        return customerService.getAllCustomer();
    }

    @GetMapping("/customers/{id}")
    public CustomerResultDTO getCustomer(@PathVariable Long id) {

        return customerService.getCustomer(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }


    @DeleteMapping("/customers")
    public void deleteAllCustomer() {
        customerService.deleteAllCustomer();

    }

}
