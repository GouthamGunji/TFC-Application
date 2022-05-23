package com.example.demo.repository;

import com.example.demo.model.DateModel;
import com.example.demo.model.Inventory;
import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    //Inventory findByProductsAndDateId(Product product, DateModel dateModel);

    Inventory findByProducts(Product product);
}
