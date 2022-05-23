package com.fresh_connection.delivery.services;

import com.fresh_connection.delivery.entities.Delivery;
import com.fresh_connection.delivery.dto.DeliveryDTO;

public interface DeliveryService {

	public Delivery deliveryDetails(DeliveryDTO deliveryDto);

}
