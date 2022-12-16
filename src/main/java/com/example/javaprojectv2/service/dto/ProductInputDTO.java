package com.example.javaprojectv2.service.dto;

import com.example.javaprojectv2.model.ProductCategory;
import com.sun.istack.NotNull;

public class ProductInputDTO {

    @NotNull
    private Long categoryId;
    @NotNull
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private String picture;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
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
        return "ProductInputDTO{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}
