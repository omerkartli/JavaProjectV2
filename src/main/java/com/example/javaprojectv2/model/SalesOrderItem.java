package com.example.javaprojectv2.model;


import javax.persistence.*;

@Entity
@Table(name= "sales_order_item")

public class SalesOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "sales_order")
    private String salesOrder;
    @Column(name = "product")
    private String product;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "price")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
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
