package com.example.javaprojectv2.service.dto;

import javax.persistence.Id;

public class ProductCategoryResultDTO {


    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCategoryResultDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
