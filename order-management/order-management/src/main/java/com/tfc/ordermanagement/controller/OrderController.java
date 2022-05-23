package com.tfc.ordermanagement.controller;

import com.tfc.ordermanagement.dto.OrderRequestDTO;
import com.tfc.ordermanagement.exception.OrderNotProcessedException;
import com.tfc.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderRequestDTO orderRequestDTO)
            throws OrderNotProcessedException {
        return  orderService.createOrder(orderRequestDTO);
    }

    @PostMapping("/processOrder/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String processOrder(@PathVariable Integer orderId)
            throws OrderNotProcessedException {
        return  orderService.processTheOrder(orderId);
    }
}
