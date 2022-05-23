package com.example.demo.service;

import com.example.demo.dto.ProductionDetailsDto;
import com.example.demo.model.Product;
import com.example.demo.model.Production;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductionService {
    @Autowired
    private ProductionRepository productionRepository;
    @Autowired
    private ProductRepository productRepository;

    public ProductionDetailsDto getProductProductionDetails(Integer productId) {
        Product product = productRepository.getById(productId);

        Production production = productionRepository.findByProducts(product);

        return getProductionDetailsDto(production, productId);
    }

    private ProductionDetailsDto getProductionDetailsDto(Production production, Integer productId) {
        ProductionDetailsDto productionDetailsDto = new ProductionDetailsDto();
        productionDetailsDto.setProduct(production.getProducts().stream()
                .filter(product -> product.getProductID()==productId)
                .collect(Collectors.toList()).get(0)
        );

        return productionDetailsDto;
    }

    public String updateProductionDetails(Production production) {
        productionRepository.save(production);
        return "Production Details updated succesfully";
    }
}
