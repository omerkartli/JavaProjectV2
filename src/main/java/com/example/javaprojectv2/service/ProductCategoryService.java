package com.example.javaprojectv2.service;


import com.example.javaprojectv2.model.Customer;
import com.example.javaprojectv2.model.ProductCategory;
import com.example.javaprojectv2.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public ProductCategory updateProductCategory(ProductCategory updateProductCategory, Long id) {
        Optional<ProductCategory> currentProductCategory = getProductCategory(id);
        if (currentProductCategory.isPresent()) {
            ProductCategory productCategory = currentProductCategory.get();
            productCategory.setName(updateProductCategory.getName());
            return productCategoryRepository.save(productCategory);
        }
        return null;
    }

    public List<ProductCategory> getAllProductCategory() {
        List<ProductCategory> customers = productCategoryRepository.findAll();
        return customers;
    }

    public Optional<ProductCategory> getProductCategory(Long id) {
        Optional<ProductCategory> customer = productCategoryRepository.findById(id);
        if (customer.isEmpty()) {
            System.out.println(" Product Category Not found");
        }
        return customer;
    }

    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }

    public void deleteAllProductCategory() {
        productCategoryRepository.deleteAll();
    }
}
