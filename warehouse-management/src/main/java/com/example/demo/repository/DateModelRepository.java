package com.example.demo.repository;

import com.example.demo.model.DateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateModelRepository extends JpaRepository<DateModel, Integer> {
}
