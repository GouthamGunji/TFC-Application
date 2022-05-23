package com.management.model.orderwebmodel;

import lombok.Data;

@Data
public class OrderLineItems {
    private Integer orderLineId;
    private String orderNumber;
    private Integer productId;
    private Integer quantity;
    private Integer price;
}
