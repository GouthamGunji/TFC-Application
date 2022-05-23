package com.fresh_connection.delivery.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fresh_connection.delivery.entities.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
	public Optional<Customer> findById(Long id);

}
