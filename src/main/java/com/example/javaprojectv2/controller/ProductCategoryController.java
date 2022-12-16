package com.example.javaprojectv2.controller;


import com.example.javaprojectv2.model.ProductCategory;
import com.example.javaprojectv2.service.ProductCategoryService;
import com.example.javaprojectv2.service.dto.ProductCategoryInputDTO;
import com.example.javaprojectv2.service.dto.ProductCategoryResultDTO;
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
    public ProductCategoryResultDTO saveProductCategory(@RequestBody ProductCategoryInputDTO productCategoryInputDTO) {
        return productCategoryService.saveProductCategory(productCategoryInputDTO);
    }
    @PutMapping("/product-categories/{id}")
    public ProductCategoryResultDTO updateProductCategory(@RequestBody ProductCategoryInputDTO productCategoryInputDTO, @PathVariable() Long id) {
        return productCategoryService.updateProductCategory(productCategoryInputDTO, id);
    }

    @GetMapping("/product-categories")
    public List<ProductCategoryResultDTO> getAllProductCategory() {

        return productCategoryService.getAllProductCategory();
    }
    @GetMapping("/product-categories/{id}")
    public ProductCategoryResultDTO getProductCategory(@PathVariable Long id) {

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
