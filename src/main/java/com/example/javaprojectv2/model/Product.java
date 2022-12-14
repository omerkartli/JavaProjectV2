package com.example.javaprojectv2.model;

import com.sun.istack.NotNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    //@JoinColumn(name = "product_category_name")//foreign key
    private ProductCategory category;

    @NotNull
    private String name;
    @NotNull
    private Double price;

    private String picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
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
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}
