package com.example.javaprojectv2.service;


import com.example.javaprojectv2.model.Product;
import com.example.javaprojectv2.model.ProductCategory;
import com.example.javaprojectv2.repository.ProductCategoryRepository;
import com.example.javaprojectv2.repository.ProductRepository;
import com.example.javaprojectv2.service.dto.ProductCategoryResultDTO;
import com.example.javaprojectv2.service.dto.ProductInputDTO;
import com.example.javaprojectv2.service.dto.ProductResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductResultDTO saveProduct(ProductInputDTO productInputDTO) {

        Product product=new Product();
        product.setName(productInputDTO.getName());
        product.setPrice(productInputDTO.getPrice());
        product.setPicture(productInputDTO.getPicture());

        ProductCategory productCategory=new ProductCategory();
        productCategory.setId(productInputDTO.getCategoryId());
        product.setCategory(productCategory);//set categoryne

        product = productRepository.save(product);

        ProductResultDTO productResultDTO=new ProductResultDTO();
        productResultDTO.setId(product.getId());
        productResultDTO.setName(product.getName());
        productResultDTO.setPrice(product.getPrice());
        productResultDTO.setPicture(product.getPicture());

        ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();
        productCategoryResultDTO.setId(product.getCategory().getId());
        productResultDTO.setCategoryId(productCategoryResultDTO);

        return productResultDTO;
    }

    public ProductResultDTO updateProduct(ProductInputDTO updateProduct, Long id) {
        Optional<Product> currentProduct = productRepository.findById(id);
        if (currentProduct.isPresent()) {
            Product product = currentProduct.get();

            product.setId(product.getId());
            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            product.setPicture(updateProduct.getPicture());

            ProductCategory productCategory=new ProductCategory();
            productCategory.setId(updateProduct.getCategoryId());//???
            product.setCategory(productCategory);

            product= productRepository.save(product);

            ProductResultDTO productResultDTO=new ProductResultDTO();
            productResultDTO.setId(product.getId());
            productResultDTO.setName(product.getName());
            productResultDTO.setPrice(product.getPrice());
            productResultDTO.setPicture(product.getPicture());

            ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();
            productCategoryResultDTO.setId(product.getCategory().getId());
            productResultDTO.setCategoryId(productCategoryResultDTO);

            return productResultDTO;
        }
        return null;
    }

    public List<ProductResultDTO> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductResultDTO> productResultDTOS=new ArrayList<>();
        products.forEach(product -> {
            ProductResultDTO productResultDTO=new ProductResultDTO();
            productResultDTO.setId(product.getId());
            productResultDTO.setName(product.getName());
            productResultDTO.setPrice(product.getPrice());
            productResultDTO.setPicture(product.getPicture());

            ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();

            productCategoryResultDTO.setId(product.getCategory().getId());
            productCategoryResultDTO.setName(product.getCategory().getName());

            productResultDTO.setCategoryId(productCategoryResultDTO);

            productResultDTOS.add(productResultDTO);

        });

        return productResultDTOS;

    }

    public ProductResultDTO getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        ProductResultDTO productResultDTO=new ProductResultDTO();

        if (product.isPresent()) {
            productResultDTO.setId(product.get().getId());
            productResultDTO.setName(product.get().getName());
            productResultDTO.setPrice(product.get().getPrice());
            productResultDTO.setPicture(product.get().getPicture());

            ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();

            productCategoryResultDTO.setId(product.get().getCategory().getId());
            productCategoryResultDTO.setName(product.get().getCategory().getName());

            productResultDTO.setCategoryId(productCategoryResultDTO);

        }
        return productResultDTO;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProduct() {
        productRepository.deleteAll();
    }
}

