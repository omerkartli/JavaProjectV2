package com.example.javaprojectv2.service.dto;

public class ProductResultDTO {

    private Long id;

    private ProductCategoryResultDTO category;

    private String name;

    private Double price;

    private String picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategoryResultDTO getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryResultDTO category) {
        this.category = category;
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
                ", categoryId=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}
