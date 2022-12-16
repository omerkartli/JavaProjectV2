package com.example.javaprojectv2.controller;

import com.example.javaprojectv2.model.Product;
import com.example.javaprojectv2.service.ProductService;
import com.example.javaprojectv2.service.dto.ProductInputDTO;
import com.example.javaprojectv2.service.dto.ProductResultDTO;
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
    public ProductResultDTO saveProduct(@RequestBody ProductInputDTO productInputDTO) {
        return productService.saveProduct(productInputDTO);
    }

    @PutMapping("/products/{id}")
    public ProductResultDTO updateProduct(@RequestBody ProductInputDTO productInputDTO, @PathVariable() Long id) {
        return productService.updateProduct(productInputDTO, id);
    }

    @GetMapping("/products")
    public List<ProductResultDTO> getAllProduct() {

        return productService.getAllProduct();
    }
    @GetMapping("/products/{id}")
    public ProductResultDTO getProduct(@PathVariable Long id) {

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
