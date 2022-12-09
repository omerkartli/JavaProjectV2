package com.example.javaprojectv2.model;


import javax.persistence.*;

@Entity
@Table(name= "product_category")

public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    @Column(name="product_category_name")// bu isim foreign key olacak
    // yerle aynı olmalı
    private String name;// bunu bu kadar uzatmaya gerek yok
    // fakat diğer tarafta 2 tane priv name olamsına izin vermiyor.

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
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
