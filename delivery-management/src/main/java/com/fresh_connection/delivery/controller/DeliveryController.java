package com.fresh_connection.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fresh_connection.delivery.entities.Delivery;
import com.fresh_connection.delivery.services.DeliveryService;
import com.fresh_connection.delivery.dto.DeliveryDTO;


@RestController()
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryService deliveryService;

	@PostMapping("/addDetails")
	public Delivery deliveryDetails(@RequestBody DeliveryDTO deliveryDto) {
		return deliveryService.deliveryDetails(deliveryDto);
	}

}
