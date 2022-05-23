package com.fresh_connection.delivery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fresh_connection.delivery.dao.CustomerDao;
import com.fresh_connection.delivery.dao.DateDao;
import com.fresh_connection.delivery.dao.DeliveryDao;
import com.fresh_connection.delivery.dao.ProductDao;
import com.fresh_connection.delivery.entities.Customer;
import com.fresh_connection.delivery.entities.Date;
import com.fresh_connection.delivery.entities.Delivery;
import com.fresh_connection.delivery.entities.Product;
import com.fresh_connection.delivery.dto.DeliveryDTO;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryDao deliveryDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private DateDao dateDao;

	@Override
	public Delivery deliveryDetails(DeliveryDTO deliveryDto) {
		Delivery delivery=new Delivery();
     	Customer customer= customerDao.findById(deliveryDto.getCustomerId()).get();
		Product product = productDao.findById(deliveryDto.getProductId()).get();
		Date date = dateDao.findById(deliveryDto.getDateId()).get();
		delivery.setCustomer(customer);
		delivery.setProduct(product);
		delivery.setDate(date);
		return deliveryDao.save(delivery);
	}

}
