package com.example.javaprojectv2.service.dto;

import com.sun.istack.NotNull;

public class SalesOrderItemInputDTO {

    @NotNull
    private Long salesOrderId;
    @NotNull
    private Long productId;
    @NotNull
    private Integer amount;
    @NotNull
    private Double price;

    public Long getSalesOrderId() {
        return salesOrderId;
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

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "SalesOrderItemInputDTO{" +
                "salesOrderId=" + salesOrderId +
                ", productId=" + productId +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
