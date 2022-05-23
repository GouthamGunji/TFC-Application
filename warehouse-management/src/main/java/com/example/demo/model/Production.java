package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCTION")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer shelfLife;
    private Integer numberPerPalletLayer;
    private Integer numberPerPallet;
    private Double litersPerPack;
    private Integer salesPriceRetail;
    private Double amountOrange;
    private Double amountMango;
    private Double amountVitaminC;
    private Double amountWater;
    @OneToMany
    private List<Product> products;
}
