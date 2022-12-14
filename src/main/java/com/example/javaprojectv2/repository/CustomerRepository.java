package com.example.javaprojectv2.repository;

import com.example.javaprojectv2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findFirstByUsernameAndUserpassword(String username, String userPassword);

}

