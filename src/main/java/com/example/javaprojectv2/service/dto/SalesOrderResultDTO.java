package com.example.javaprojectv2.service.dto;

import java.util.Date;

public class SalesOrderResultDTO {

    private Long id;

    private CustomerResultDTO customer;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerResultDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResultDTO customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", date=" + date +
                '}';
    }
}
