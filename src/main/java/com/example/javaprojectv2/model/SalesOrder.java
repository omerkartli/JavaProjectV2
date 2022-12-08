package com.example.javaprojectv2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sales_order")

public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="customer")
    private String customer;// bu da foreign key olacak m:1
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
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
