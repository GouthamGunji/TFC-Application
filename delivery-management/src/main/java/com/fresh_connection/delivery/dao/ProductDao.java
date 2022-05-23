package com.fresh_connection.delivery.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresh_connection.delivery.entities.Customer;
import com.fresh_connection.delivery.entities.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

	public Optional<Product> findById(Long id);
}
