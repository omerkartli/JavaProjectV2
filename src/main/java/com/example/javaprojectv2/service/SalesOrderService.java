package com.example.javaprojectv2.service;

import com.example.javaprojectv2.model.Customer;
import com.example.javaprojectv2.model.SalesOrder;
import com.example.javaprojectv2.repository.CustomerRepository;
import com.example.javaprojectv2.repository.SalesOrderRepository;
import com.example.javaprojectv2.service.dto.CustomerResultDTO;
import com.example.javaprojectv2.service.dto.SalesOrderInputDTO;
import com.example.javaprojectv2.service.dto.SalesOrderResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {
    @Autowired
    SalesOrderRepository salesOrderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public SalesOrderResultDTO saveSalesOrder(SalesOrderInputDTO salesOrderInputDTO) {

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setDate(salesOrderInputDTO.getDate());

        Customer customer = new Customer();
        customer.setId(salesOrderInputDTO.getCustomerId());
        salesOrder.setCustomer(customer);

        salesOrder = salesOrderRepository.save(salesOrder);

        SalesOrderResultDTO salesOrderResultDTO = new SalesOrderResultDTO();
        salesOrderResultDTO.setId(salesOrder.getId());
        salesOrderResultDTO.setDate(salesOrder.getDate());

        CustomerResultDTO result = new CustomerResultDTO();
        result.setId(salesOrder.getCustomer().getId());
        salesOrderResultDTO.setCustomer(result);

        return salesOrderResultDTO;
    }

    public SalesOrderResultDTO updateSalesOrder(SalesOrderInputDTO updateSalesOrder, Long id) {
        Optional<SalesOrder> currentSalesOrder = salesOrderRepository.findById(id);
        if (currentSalesOrder.isPresent()) {
            SalesOrder salesOrder = currentSalesOrder.get();

            salesOrder.setId(salesOrder.getId());
            salesOrder.setDate(updateSalesOrder.getDate());

            Customer customer=new Customer();
            customer.setId(updateSalesOrder.getCustomerId());
            salesOrder.setCustomer(customer);

            salesOrder=salesOrderRepository.save(salesOrder);

            SalesOrderResultDTO salesOrderResultDTO=new SalesOrderResultDTO();
            salesOrderResultDTO.setId(salesOrder.getId());
            salesOrderResultDTO.setDate(salesOrder.getDate());

            CustomerResultDTO result = new CustomerResultDTO();
            result.setId(salesOrder.getCustomer().getId());
            salesOrderResultDTO.setCustomer(result);
            return salesOrderResultDTO;
        }
        return null;
    }

    public List<SalesOrderResultDTO> getAllSalesOrder() {
        List<SalesOrder> salesOrderEntityList = salesOrderRepository.findAll();
        List<SalesOrderResultDTO> results=new ArrayList<>();
        salesOrderEntityList.forEach(salesOrder -> {
            SalesOrderResultDTO result=new SalesOrderResultDTO();
            result.setId(salesOrder.getId());
            result.setDate(salesOrder.getDate());

            CustomerResultDTO customerResult = new CustomerResultDTO();

            customerResult.setId(salesOrder.getCustomer().getId());
            customerResult.setName(salesOrder.getCustomer().getName());
            customerResult.setSurname(salesOrder.getCustomer().getSurname());
            customerResult.setUsername(salesOrder.getCustomer().getUsername());
            customerResult.setRole(salesOrder.getCustomer().getRole());

            result.setCustomer(customerResult);

            results.add(result);
        });
        return results;
    }

    public SalesOrderResultDTO getSalesOrder(Long id) {
        Optional<SalesOrder> salesOrder = salesOrderRepository.findById(id);
        SalesOrderResultDTO result = new SalesOrderResultDTO();
        if (salesOrder.isPresent()) {
            result.setId(salesOrder.get().getId());
            result.setDate(salesOrder.get().getDate());

            CustomerResultDTO customerResult = new CustomerResultDTO();

            customerResult.setId(salesOrder.get().getCustomer().getId());
            customerResult.setName(salesOrder.get().getCustomer().getName());
            customerResult.setSurname(salesOrder.get().getCustomer().getSurname());
            customerResult.setUsername(salesOrder.get().getCustomer().getUsername());
            customerResult.setRole(salesOrder.get().getCustomer().getRole());

            result.setCustomer(customerResult);
        }
        return result;
    }

    public void deleteSalesOrder(Long id) {
        salesOrderRepository.deleteById(id);
    }

    public void deleteAllSalesOrder() {
        salesOrderRepository.deleteAll();
    }
}
