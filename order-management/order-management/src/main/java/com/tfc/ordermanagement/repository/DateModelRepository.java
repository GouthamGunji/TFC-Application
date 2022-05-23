package com.tfc.ordermanagement.repository;

import com.tfc.ordermanagement.model.DateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateModelRepository extends JpaRepository<DateModel, Integer> {
}
