package com.management.controller;

import com.management.model.orderwebmodel.OrderDetails;
import com.management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired private OrderService service;

    @PostMapping("/processorder")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean processTheOrder(@RequestBody OrderDetails orderDetails) {
        return service.processOrder(orderDetails);
    }
}
