package com.example.demo.controller;

import com.example.demo.dto.ProductionDetailsDto;
import com.example.demo.model.Inventory;
import com.example.demo.model.Production;
import com.example.demo.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/production")
public class ProductionController {
    @Autowired
    private ProductionService productionService;

    @GetMapping("/product/{productId}")
    public ProductionDetailsDto getProductProductionDetails(@PathVariable Integer productId){
        return productionService.getProductProductionDetails(productId);
    }

    @PostMapping("/updateProductionDetails")
    public String updateProductionDetails(@RequestBody Production production) {
        return productionService.updateProductionDetails(production);
    }
}
