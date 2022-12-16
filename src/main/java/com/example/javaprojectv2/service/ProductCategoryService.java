package com.example.javaprojectv2.service;

import com.example.javaprojectv2.model.ProductCategory;
import com.example.javaprojectv2.repository.ProductCategoryRepository;
import com.example.javaprojectv2.service.dto.ProductCategoryInputDTO;
import com.example.javaprojectv2.service.dto.ProductCategoryResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public ProductCategoryResultDTO saveProductCategory(ProductCategoryInputDTO productCategoryInputDTO) {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setName(productCategoryInputDTO.getName());

        productCategory=productCategoryRepository.save(productCategory);

        ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();
        productCategory.setName(productCategory.getName());

        return productCategoryResultDTO;
    }

    public ProductCategoryResultDTO updateProductCategory(ProductCategoryInputDTO updateProductCategory, Long id) {
        Optional<ProductCategory> currentProductCategory = productCategoryRepository.findById(id);
        if (currentProductCategory.isPresent()) {
            ProductCategory productCategory = currentProductCategory.get();

            productCategory.setName(updateProductCategory.getName());
            productCategory= productCategoryRepository.save(productCategory);

            ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();
            productCategoryResultDTO.setName(productCategory.getName());
            return productCategoryResultDTO;
        }
        return null;
    }

    public List<ProductCategoryResultDTO> getAllProductCategory() {
        List<ProductCategory> productCategories=productCategoryRepository.findAll();
        List<ProductCategoryResultDTO> productCategoryResultDTOS = new ArrayList<>();
        productCategories.forEach( productCategory-> {
            ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();
            productCategoryResultDTO.setId(productCategory.getId());
            productCategoryResultDTO.setName(productCategory.getName());
            productCategoryResultDTOS.add(productCategoryResultDTO);
        });
        return productCategoryResultDTOS;
    }

    public ProductCategoryResultDTO getProductCategory(Long id) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
        ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();
        if (productCategory.isPresent()) {
            productCategoryResultDTO.setId(productCategory.get().getId());
            productCategoryResultDTO.setName(productCategory.get().getName());
        }
        return productCategoryResultDTO;
    }

    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }

    public void deleteAllProductCategory() {
        productCategoryRepository.deleteAll();
    }
}
