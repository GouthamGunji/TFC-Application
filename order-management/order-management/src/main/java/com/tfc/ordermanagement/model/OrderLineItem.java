package com.tfc.ordermanagement.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDER_LINE_ITEMS")
public class OrderLineItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer orderLineId;
   private Integer productId;
   private Integer quantity;
   private Integer price;

}
