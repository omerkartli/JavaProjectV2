package com.example.javaprojectv2.controller;

import com.example.javaprojectv2.model.Product;
import com.example.javaprojectv2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable() Long id) {
        return productService.updateProduct(product, id);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {

        return productService.getAllProduct();
    }
    @GetMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {

        return productService.getProduct(id);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    @DeleteMapping("/products")
    public void deleteAllProduct() {
        productService.deleteAllProduct();

    }
}
