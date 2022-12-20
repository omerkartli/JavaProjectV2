package com.example.javaprojectv2.service;

import com.example.javaprojectv2.model.Product;
import com.example.javaprojectv2.model.SalesOrder;
import com.example.javaprojectv2.model.SalesOrderItem;
import com.example.javaprojectv2.repository.SalesOrderItemRepository;
import com.example.javaprojectv2.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SalesOrderItemService {

    @Autowired
    SalesOrderItemRepository salesOrderItemRepository;

    public SalesOrderItemResultDTO saveSalesOrderItem(SalesOrderItemInputDTO salesOrderItemInputDTO) {
        SalesOrderItem salesOrderItem = new SalesOrderItem();
        salesOrderItem.setAmount(salesOrderItemInputDTO.getAmount());
        salesOrderItem.setPrice(salesOrderItemInputDTO.getPrice());

        Product product = new Product();
        product.setId(salesOrderItemInputDTO.getProductId());
        salesOrderItem.setProduct(product);

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setId(salesOrderItemInputDTO.getSalesOrderId());
        salesOrderItem.setSalesOrder(salesOrder);

        salesOrderItem = salesOrderItemRepository.save(salesOrderItem);

        SalesOrderItemResultDTO salesOrderItemResultDTO = new SalesOrderItemResultDTO();
        salesOrderItemResultDTO.setId(salesOrderItem.getId());
        salesOrderItemResultDTO.setAmount(salesOrderItem.getAmount());
        salesOrderItemResultDTO.setPrice(salesOrderItem.getPrice());

        ProductResultDTO productResultDTO = new ProductResultDTO();
        productResultDTO.setId(salesOrderItem.getProduct().getId());
        salesOrderItemResultDTO.setProduct(productResultDTO);

        SalesOrderResultDTO salesOrderResultDTO = new SalesOrderResultDTO();
        salesOrderResultDTO.setId(salesOrderItem.getSalesOrder().getId());
        salesOrderItemResultDTO.setSalesOrder(salesOrderResultDTO);

        return salesOrderItemResultDTO;
    }

    public SalesOrderItemResultDTO updateSalesOrderItem(SalesOrderItemInputDTO updateSalesOrderItem, Long id) {
        Optional<SalesOrderItem> currentSalesOrderItem = salesOrderItemRepository.findById(id);
        if (currentSalesOrderItem.isPresent()) {
            SalesOrderItem salesOrderItem = currentSalesOrderItem.get();

            salesOrderItem.setId(salesOrderItem.getId());
            salesOrderItem.setAmount(updateSalesOrderItem.getAmount());
            salesOrderItem.setPrice(updateSalesOrderItem.getPrice());

            Product product=new Product();
            product.setId(updateSalesOrderItem.getProductId());
            salesOrderItem.setProduct(product);

            SalesOrder salesOrder=new SalesOrder();
            salesOrder.setId(updateSalesOrderItem.getSalesOrderId());
            salesOrderItem.setSalesOrder(salesOrder);

            salesOrderItem=salesOrderItemRepository.save(salesOrderItem);

            SalesOrderItemResultDTO salesOrderItemResultDTO=new SalesOrderItemResultDTO();
            salesOrderItemResultDTO.setId(salesOrderItem.getId());
            salesOrderItemResultDTO.setAmount(salesOrderItem.getAmount());
            salesOrderItemResultDTO.setPrice(salesOrderItem.getPrice());

            ProductResultDTO productResultDTO =new ProductResultDTO();
            productResultDTO.setId(salesOrderItem.getProduct().getId());
            salesOrderItemResultDTO.setProduct(productResultDTO);

            SalesOrderResultDTO salesOrderResultDTO=new SalesOrderResultDTO();
            salesOrderResultDTO.setId(salesOrderItem.getSalesOrder().getId());
            salesOrderItemResultDTO.setSalesOrder(salesOrderResultDTO);

            return salesOrderItemResultDTO;
        }
        return null;
    }

    public List<SalesOrderItemResultDTO> getAllSalesOrderItem() {
        List<SalesOrderItem> salesOrdersItems = salesOrderItemRepository.findAll();
        List<SalesOrderItemResultDTO> salesOrderItemResultDTOS=new ArrayList<>();
        salesOrdersItems.forEach(salesOrderItem -> {
            SalesOrderItemResultDTO salesOrderItemResultDTO =new SalesOrderItemResultDTO();
            salesOrderItemResultDTO.setId(salesOrderItem.getId());
            salesOrderItemResultDTO.setAmount(salesOrderItem.getAmount());
            salesOrderItemResultDTO.setPrice(salesOrderItem.getPrice());

            ProductResultDTO productResultDTO=new ProductResultDTO();
            productResultDTO.setId(salesOrderItem.getProduct().getId());
            productResultDTO.setName(salesOrderItem.getProduct().getName());
            productResultDTO.setPicture(salesOrderItem.getProduct().getPicture());
            productResultDTO.setPrice(salesOrderItem.getProduct().getPrice());

            ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();
            productCategoryResultDTO.setId(salesOrderItem.getProduct().getCategory().getId());
            productCategoryResultDTO.setName(salesOrderItem.getProduct().getCategory().getName());

            salesOrderItemResultDTO.setProduct(productResultDTO);
            productResultDTO.setCategory(productCategoryResultDTO);



            SalesOrderResultDTO salesOrderResultDTO=new SalesOrderResultDTO();
            salesOrderResultDTO.setId(salesOrderItem.getSalesOrder().getId());
            salesOrderResultDTO.setDate(salesOrderItem.getSalesOrder().getDate());

            CustomerResultDTO customerResultDTO=new CustomerResultDTO();
            customerResultDTO.setId(salesOrderItem.getSalesOrder().getCustomer().getId());
            customerResultDTO.setName(salesOrderItem.getSalesOrder().getCustomer().getName());
            customerResultDTO.setSurname(salesOrderItem.getSalesOrder().getCustomer().getSurname());
            customerResultDTO.setUsername(salesOrderItem.getSalesOrder().getCustomer().getUsername());
            customerResultDTO.setRole(salesOrderItem.getSalesOrder().getCustomer().getRole());

            salesOrderItemResultDTO.setSalesOrder(salesOrderResultDTO);
            salesOrderResultDTO.setCustomer(customerResultDTO);
            salesOrderItemResultDTOS.add(salesOrderItemResultDTO);


        });

        return salesOrderItemResultDTOS;
    }

    public SalesOrderItemResultDTO getSalesOrderItem(Long id) {
        Optional<SalesOrderItem> salesOrdersItem = salesOrderItemRepository.findById(id);
        SalesOrderItemResultDTO salesOrderItemResultDTO=new SalesOrderItemResultDTO();
        if (salesOrdersItem.isPresent()) {
            salesOrderItemResultDTO.setId(salesOrdersItem.get().getId());
            salesOrderItemResultDTO.setAmount(salesOrdersItem.get().getAmount());
            salesOrderItemResultDTO.setPrice(salesOrdersItem.get().getPrice());

            ProductResultDTO productResultDTO=new ProductResultDTO();
            productResultDTO.setId(salesOrdersItem.get().getProduct().getId());
            productResultDTO.setName(salesOrdersItem.get().getProduct().getName());
            productResultDTO.setPicture(salesOrdersItem.get().getProduct().getPicture());
            productResultDTO.setPrice(salesOrdersItem.get().getProduct().getPrice());

            ProductCategoryResultDTO productCategoryResultDTO=new ProductCategoryResultDTO();
            productCategoryResultDTO.setId(salesOrdersItem.get().getProduct().getCategory().getId());
            productCategoryResultDTO.setName(salesOrdersItem.get().getProduct().getCategory().getName());

            salesOrderItemResultDTO.setProduct(productResultDTO);
            productResultDTO.setCategory(productCategoryResultDTO);



            SalesOrderResultDTO salesOrderResultDTO=new SalesOrderResultDTO();
            salesOrderResultDTO.setId(salesOrdersItem.get().getSalesOrder().getId());
            salesOrderResultDTO.setDate(salesOrdersItem.get().getSalesOrder().getDate());

            CustomerResultDTO customerResultDTO=new CustomerResultDTO();
            customerResultDTO.setId(salesOrdersItem.get().getSalesOrder().getCustomer().getId());
            customerResultDTO.setName(salesOrdersItem.get().getSalesOrder().getCustomer().getName());
            customerResultDTO.setSurname(salesOrdersItem.get().getSalesOrder().getCustomer().getSurname());
            customerResultDTO.setUsername(salesOrdersItem.get().getSalesOrder().getCustomer().getUsername());
            customerResultDTO.setRole(salesOrdersItem.get().getSalesOrder().getCustomer().getRole());

            salesOrderItemResultDTO.setSalesOrder(salesOrderResultDTO);
            salesOrderResultDTO.setCustomer(customerResultDTO);

        }
        return salesOrderItemResultDTO;
    }

    public void deleteSalesOrderItem(Long id) {
        salesOrderItemRepository.deleteById(id);
    }

    public void deleteAllSalesOrderItem() {
        salesOrderItemRepository.deleteAll();
    }
}
