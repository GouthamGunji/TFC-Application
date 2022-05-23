package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "INVENTORY")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private DateModel date;
    @OneToMany
    private List<Product> products;
    private Long stockLeft;
    private Long reservedStock;
    private Long startUpLoss;
    private Long Obsoletes;
    private Long backOrder;
}
