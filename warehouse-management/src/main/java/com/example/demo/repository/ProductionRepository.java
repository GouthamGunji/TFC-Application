package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Integer> {
    Production findByProducts(Product product);
}
