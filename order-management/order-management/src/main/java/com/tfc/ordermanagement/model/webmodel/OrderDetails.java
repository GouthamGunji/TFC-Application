package com.tfc.ordermanagement.model.webmodel;

import com.tfc.ordermanagement.model.OrderLineItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetails {
    private Integer orderId;
    private Integer customerID;
    private Integer orderDateId;
    private Integer deliveryDateId;
    private List<OrderLineItem> orderLineItems;
}
