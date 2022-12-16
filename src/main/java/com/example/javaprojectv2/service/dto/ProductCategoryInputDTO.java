package com.example.javaprojectv2.service.dto;

import com.sun.istack.NotNull;

public class ProductCategoryInputDTO {


    @NotNull
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCategoryInputDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
