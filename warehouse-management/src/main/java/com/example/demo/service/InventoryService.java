package com.example.demo.service;

import com.example.demo.dto.InventoryDetailsDto;
import com.example.demo.model.Inventory;
import com.example.demo.model.Product;
import com.example.demo.repository.DateModelRepository;
import com.example.demo.repository.InventoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private DateModelRepository dateModelRepository;
    @Autowired
    private ProductRepository productRepository;

    public InventoryDetailsDto getProductInventoryDetails(Integer productId) {
        Product product = productRepository.getById(productId);

        Inventory inventory = inventoryRepository.findByProducts(product);

        return getProductInventoryDto(inventory, productId);
    }

    private InventoryDetailsDto getProductInventoryDto(Inventory inventory, Integer productId) {
        InventoryDetailsDto inventoryDetailsDto = new InventoryDetailsDto();

        inventoryDetailsDto.setProduct(inventory.getProducts()
                .stream()
                .filter(product -> product.getProductID() == productId)
                .collect(Collectors.toList()).get(0)
        );
        inventoryDetailsDto.setStockLeft(inventory.getStockLeft());

        return inventoryDetailsDto;
    }

    public String saveInventoryDetails(Inventory inventory) {
        inventoryRepository.save(inventory);
        return "Inventory Details Updated";
    }
}
