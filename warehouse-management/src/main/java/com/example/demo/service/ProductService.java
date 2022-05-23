package com.example.demo.service;

import com.example.demo.exception.TechnicalException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String addProduct(Product product) throws TechnicalException {
        if(productRepository.existsById(product.getProductID())){
            throw new TechnicalException("Product already exists");
        }
        productRepository.save(product);
        return "Product saved Successfully";
    }
}
