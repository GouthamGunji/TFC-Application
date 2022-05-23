package com.fresh_connection.delivery.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fresh_connection.delivery.entities.Customer;
import com.fresh_connection.delivery.entities.Date;

@Repository
public interface DateDao extends JpaRepository<Date, Long> {
	public Optional<Date> findById(Long id);
}
