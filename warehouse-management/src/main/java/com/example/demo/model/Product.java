package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    private Integer productID;
    private String productName;
    private Long numberPerProduction;
    private Integer reservedProductionDays;
    @ManyToOne
    private Inventory inventory;


}
