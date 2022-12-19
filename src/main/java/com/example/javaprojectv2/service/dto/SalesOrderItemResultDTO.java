package com.example.javaprojectv2.service.dto;

public class SalesOrderItemResultDTO {

    private Long id;

    private SalesOrderResultDTO salesOrderId;

    private ProductResultDTO productId;

    private Integer amount;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SalesOrderResultDTO getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(SalesOrderResultDTO salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public ProductResultDTO getProductId() {
        return productId;
    }

    public void setProductId(ProductResultDTO productId) {
        this.productId = productId;
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
                ", salesOrderId=" + salesOrderId +
                ", productId=" + productId +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
