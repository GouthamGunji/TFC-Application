package com.management.service;

import com.management.model.orderwebmodel.OrderDetails;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Boolean processOrder(OrderDetails orderDetails) {
        //Todo - Step-1 : collect the orderlines from Order based on product Id
        //Todo - Step-2 : collect the inventory level for that product based on date
        //Todo - Step-3 : if the order level exceeds the inventory level check for

        return Boolean.TRUE;
    }
}
