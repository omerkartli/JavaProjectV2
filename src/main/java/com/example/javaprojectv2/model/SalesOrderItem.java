package com.example.javaprojectv2.model;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "sales_order_item")

public class SalesOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private SalesOrder salesOrder;

    @NotNull
    @ManyToOne
    private Product product;

    @NotNull
    private Integer amount;

    @NotNull
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SalesOrderItem{" +
                "id=" + id +
                ", order='" + salesOrder + '\'' +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
