package com.tfc.ordermanagement.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CUSTOMER")
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer customerID;
   private String customerName;
}
