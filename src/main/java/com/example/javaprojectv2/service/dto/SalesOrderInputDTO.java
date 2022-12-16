package com.example.javaprojectv2.service.dto;

import com.sun.istack.NotNull;

import java.util.Date;

public class SalesOrderInputDTO {


    @NotNull
    private Long customerId;

    @NotNull
    private Date date;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SalesOrderInputDTO{" +
                "customerId=" + customerId +
                ", date=" + date +
                '}';
    }
}
