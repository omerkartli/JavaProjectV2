package com.example.javaprojectv2.controller;

import com.example.javaprojectv2.model.SalesOrderItem;
import com.example.javaprojectv2.model.SalesOrderItem;
import com.example.javaprojectv2.service.SalesOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SalesOrderItemController {

    @Autowired
    SalesOrderItemService salesOrderItemService;

    @PostMapping("/sales-order-items")
    public SalesOrderItem saveSalesOrderItem(@RequestBody SalesOrderItem productCategory) {
        return salesOrderItemService.saveSalesOrderItem(productCategory);
    }
    @PutMapping("/sales-order-items/{id}")
    public SalesOrderItem updateSalesOrderItem(@RequestBody SalesOrderItem productCategory, @PathVariable() Long id) {
        return salesOrderItemService.updateSalesOrderItem(productCategory, id);
    }

    @GetMapping("/sales-order-items")
    public List<SalesOrderItem> getAllSalesOrderItem() {

        return salesOrderItemService.getAllSalesOrderItem();
    }
    @GetMapping("/sales-order-items/{id}")
    public Optional<SalesOrderItem> getSalesOrderItem(@PathVariable Long id) {

        return salesOrderItemService.getSalesOrderItem(id);
    }
    @DeleteMapping("/sales-order-items/{id}")
    public void deleteProductCategoriy(@PathVariable Long id) {
        salesOrderItemService.deleteSalesOrderItem(id);
    }

    @DeleteMapping("/sales-order-items")
    public void deleteAllSalesOrderItem() {
        salesOrderItemService.deleteAllSalesOrderItem();

    }
}
