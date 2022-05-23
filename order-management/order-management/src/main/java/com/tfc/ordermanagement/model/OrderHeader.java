package com.tfc.ordermanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Order_Header")
public class OrderHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    @ManyToOne
    private Customer customerId;
    private String status;
    @OneToOne
    private DateModel orderDateId;
    @OneToOne
    private DateModel deliveryDateId;
    @OneToMany
    private List<OrderLineItem> orderLineItems;
}
