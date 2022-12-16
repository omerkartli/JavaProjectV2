package com.example.javaprojectv2.controller;


import com.example.javaprojectv2.service.SalesOrderService;
import com.example.javaprojectv2.service.dto.SalesOrderInputDTO;
import com.example.javaprojectv2.service.dto.SalesOrderResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SalesOrderController {

    @Autowired
    SalesOrderService salesOrderService;

    @PostMapping("/sales-orders")
    public SalesOrderResultDTO saveSalesOrder(@RequestBody SalesOrderInputDTO salesOrderInputDTO) {
        return salesOrderService.saveSalesOrder(salesOrderInputDTO);
    }

    @PutMapping("/sales-orders/{id}")
    public SalesOrderResultDTO updateSalesOrder(@RequestBody SalesOrderInputDTO salesOrderInputDTO, @PathVariable() Long id) {
        return salesOrderService.updateSalesOrder(salesOrderInputDTO, id);
    }

    @GetMapping("/sales-orders")
    public List<SalesOrderResultDTO> getAllSalesOrder() {

        return salesOrderService.getAllSalesOrder();
    }

    @GetMapping("/sales-orders/{id}")
    public SalesOrderResultDTO getSalesOrder(@PathVariable Long id) {

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
