package com.example.javaprojectv2.controller;


import com.example.javaprojectv2.model.SalesOrder;
import com.example.javaprojectv2.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SalesOrderController {

    @Autowired
    SalesOrderService salesOrderService;

    @PostMapping("/sales-orders")
    public SalesOrder saveSalesOrder(@RequestBody SalesOrder salesOrder) {
        return salesOrderService.saveSalesOrder(salesOrder);
    }
    @PutMapping("/sales-orders/{id}")
    public SalesOrder updateSalesOrder(@RequestBody SalesOrder salesOrder, @PathVariable() Long id) {
        return salesOrderService.updateSalesOrder(salesOrder, id);
    }

    @GetMapping("/sales-orders")
    public List<SalesOrder> getAllSalesOrder() {

        return salesOrderService.getAllSalesOrder();
    }
    @GetMapping("/sales-orders/{id}")
    public Optional<SalesOrder> getSalesOrder(@PathVariable Long id) {

        return salesOrderService.getSalesOrder(id);
    }
    @DeleteMapping("/sales-orders/{id}")
    public void deleteProductCategoriy(@PathVariable Long id) {
        salesOrderService.deleteSalesOrder(id);
    }

    @DeleteMapping("/sales-orders")
    public void deleteAllSalesOrder() {
        salesOrderService.deleteAllSalesOrder();

    }

}
