package com.example.demo.dto;

import com.example.demo.model.Product;
import lombok.Data;

@Data
public class InventoryDetailsDto {
    private Product product;
    private Long stockLeft;
}
