package com.example.javaprojectv2.service;

import com.example.javaprojectv2.model.SalesOrder;
import com.example.javaprojectv2.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {
    @Autowired
    SalesOrderRepository salesOrderRepository;

    public SalesOrder saveSalesOrder(SalesOrder salesOrder) {
        return salesOrderRepository.save(salesOrder);
    }

    public SalesOrder updateSalesOrder(SalesOrder updateSalesOrder, Long id) {
        Optional<SalesOrder> currentSalesOrder = getSalesOrder(id);
        if (currentSalesOrder.isPresent()) {
            SalesOrder salesOrder = currentSalesOrder.get();
            salesOrder.setCustomer(updateSalesOrder.getCustomer());
            salesOrder.setDate(updateSalesOrder.getDate());
            return salesOrderRepository.save(salesOrder);
        }
        return null;
    }

    public List<SalesOrder> getAllSalesOrder() {
        List<SalesOrder> salesOrders = salesOrderRepository.findAll();
        return salesOrders;
    }

    public Optional<SalesOrder> getSalesOrder(Long id) {
        Optional<SalesOrder> customer = salesOrderRepository.findById(id);
        if (customer.isEmpty()) {
            System.out.println(" Product Category Not found");
        }
        return customer;
    }

    public void deleteSalesOrder(Long id) {
        salesOrderRepository.deleteById(id);
    }

    public void deleteAllSalesOrder() {
        salesOrderRepository.deleteAll();
    }
}
