package com.example.javaprojectv2.service.dto;

public class SalesOrderItemResultDTO {

    private Long id;

    private SalesOrderResultDTO salesOrder;

    private ProductResultDTO product;

    private Integer amount;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SalesOrderResultDTO getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrderResultDTO salesOrder) {
        this.salesOrder = salesOrder;
    }

    public ProductResultDTO getProduct() {
        return product;
    }

    public void setProduct(ProductResultDTO product) {
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
        return "SalesOrderItemResultDTO{" +
                "id=" + id +
                ", salesOrder=" + salesOrder +
                ", product=" + product +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
