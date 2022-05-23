package com.tfc.ordermanagement.repository;

import com.tfc.ordermanagement.model.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Integer> {
}
