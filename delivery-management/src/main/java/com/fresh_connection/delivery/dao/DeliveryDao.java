package com.fresh_connection.delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresh_connection.delivery.entities.Delivery;

@Repository
public interface DeliveryDao extends JpaRepository<Delivery, Long>{
	

}
