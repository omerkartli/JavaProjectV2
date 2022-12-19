package com.example.javaprojectv2.controller;

import com.example.javaprojectv2.model.SalesOrderItem;
import com.example.javaprojectv2.model.SalesOrderItem;
import com.example.javaprojectv2.service.SalesOrderItemService;
import com.example.javaprojectv2.service.dto.SalesOrderItemInputDTO;
import com.example.javaprojectv2.service.dto.SalesOrderItemResultDTO;
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
    public SalesOrderItemResultDTO saveSalesOrderItem(@RequestBody SalesOrderItemInputDTO productCategoryInputDTO) {
        return salesOrderItemService.saveSalesOrderItem(productCategoryInputDTO);
    }
    @PutMapping("/sales-order-items/{id}")
    public SalesOrderItemResultDTO updateSalesOrderItem(@RequestBody SalesOrderItemInputDTO productCategoryInputDTO, @PathVariable() Long id) {
        return salesOrderItemService.updateSalesOrderItem(productCategoryInputDTO, id);
    }

    @GetMapping("/sales-order-items")
    public List<SalesOrderItemResultDTO> getAllSalesOrderItem() {

        return salesOrderItemService.getAllSalesOrderItem();
    }
    @GetMapping("/sales-order-items/{id}")
    public SalesOrderItemResultDTO getSalesOrderItem(@PathVariable Long id) {

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
