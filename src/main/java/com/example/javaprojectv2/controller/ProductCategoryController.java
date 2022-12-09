package com.example.javaprojectv2.controller;


import com.example.javaprojectv2.model.ProductCategory;
import com.example.javaprojectv2.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping("/product-categories")
    public ProductCategory saveProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.saveProductCategory(productCategory);
    }
    @PutMapping("/product-categories/{id}")
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory, @PathVariable() Long id) {
        return productCategoryService.updateProductCategory(productCategory, id);
    }

    @GetMapping("/product-categories")
    public List<ProductCategory> getAllProductCategory() {

        return productCategoryService.getAllProductCategory();
    }
    @GetMapping("/product-categories/{id}")
    public Optional<ProductCategory> getProductCategory(@PathVariable Long id) {

        return productCategoryService.getProductCategory(id);
    }
    @DeleteMapping("/product-categories/{id}")
    public void deleteProductCategoriy(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);
    }

    @DeleteMapping("/product-categories")
    public void deleteAllProductCategory() {
        productCategoryService.deleteAllProductCategory();

    }



}
