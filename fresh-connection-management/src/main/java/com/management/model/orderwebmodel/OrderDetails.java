package com.management.model.orderwebmodel;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetails {
    private Integer orderId;
    private Integer customerID;
    private Integer orderDateId;
    private Integer deliveryDateId;
    private List<OrderLineItems> orderLineItems;

}
