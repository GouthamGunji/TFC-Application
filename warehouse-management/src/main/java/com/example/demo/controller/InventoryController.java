package com.example.demo.controller;

import com.example.demo.dto.InventoryDetailsDto;
import com.example.demo.model.Inventory;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/product/{productId}")
    public InventoryDetailsDto getProductInventoryDetails(
            @PathVariable Integer productId) {
        return inventoryService.getProductInventoryDetails(productId);
    }

    @PostMapping("/updateInventoryDetails")
    public String updateInventoryDetails(@RequestBody Inventory inventory) {
        return inventoryService.saveInventoryDetails(inventory);
    }
}
