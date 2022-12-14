package com.example.javaprojectv2.service;


import com.example.javaprojectv2.model.Product;
import com.example.javaprojectv2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product updateProduct, Long id) {
        Optional<Product> currentProduct = getProduct(id);
        if (currentProduct.isPresent()) {
            Product product = currentProduct.get();
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            product.setPicture(updateProduct.getPicture());
            product.setCategory(updateProduct.getCategory());
            return productRepository.save(product);
        }
        return null;
    }

    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Optional<Product> getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            System.out.println(" Product Not found");
        }
        return product;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProduct() {
        productRepository.deleteAll();
    }
}

