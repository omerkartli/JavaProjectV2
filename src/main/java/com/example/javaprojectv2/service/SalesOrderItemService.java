package com.example.javaprojectv2.service;

import com.example.javaprojectv2.model.SalesOrder;
import com.example.javaprojectv2.model.SalesOrderItem;
import com.example.javaprojectv2.repository.SalesOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderItemService {

    @Autowired
    SalesOrderItemRepository salesOrderItemRepository;

    public SalesOrderItem saveSalesOrderItem(SalesOrderItem salesOrderItem) {
        return salesOrderItemRepository.save(salesOrderItem);
    }

    public SalesOrderItem updateSalesOrderItem(SalesOrderItem updateSalesOrderItem, Long id) {
        Optional<SalesOrderItem> currentSalesOrderItem = getSalesOrderItem(id);
        if (currentSalesOrderItem.isPresent()) {
            SalesOrderItem salesOrderItem = currentSalesOrderItem.get();
            salesOrderItem.setSalesOrder(updateSalesOrderItem.getSalesOrder());
            salesOrderItem.setProduct(updateSalesOrderItem.getProduct());
            salesOrderItem.setAmount(updateSalesOrderItem.getAmount());
            salesOrderItem.setPrice(updateSalesOrderItem.getPrice());
            return salesOrderItemRepository.save(salesOrderItem);
        }
        return null;
    }

    public List<SalesOrderItem> getAllSalesOrderItem() {
        List<SalesOrderItem> salesOrdersItem = salesOrderItemRepository.findAll();
        return salesOrdersItem;
    }

    public Optional<SalesOrderItem> getSalesOrderItem(Long id) {
        Optional<SalesOrderItem> salesOrdersItem = salesOrderItemRepository.findById(id);
        if (salesOrdersItem.isEmpty()) {
            System.out.println(" Sales order ıtem Not found");
        }
        return salesOrdersItem;
    }

    public void deleteSalesOrderItem(Long id) {
        salesOrderItemRepository.deleteById(id);
    }

    public void deleteAllSalesOrderItem() {
        salesOrderItemRepository.deleteAll();
    }
}
