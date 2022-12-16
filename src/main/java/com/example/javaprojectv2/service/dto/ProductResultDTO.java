package com.example.javaprojectv2.service.dto;

import com.example.javaprojectv2.model.ProductCategory;

public class ProductResultDTO {

    private Long id;

    private ProductCategoryResultDTO categoryId;

    private String name;

    private Double price;

    private String picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategoryResultDTO getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(ProductCategoryResultDTO categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "ProductResultDTO{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}
