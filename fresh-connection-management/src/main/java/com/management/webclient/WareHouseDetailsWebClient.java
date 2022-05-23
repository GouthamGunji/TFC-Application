package com.management.webclient;

import com.management.model.warehousewebmodel.BackOrderDetails;
import com.management.model.warehousewebmodel.InventoryDetails;
import com.management.model.warehousewebmodel.ProductionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WareHouseDetailsWebClient {

    private static final String GET_PRODUCT_INVENTORY_Details_URL =
            "http://localhost:8081/inventory/product/{productId}/date/{dateId}";
    private static final String GET_PRODUCT_PRODUCTION_Details_URL =
            "http://localhost:8081/production/product/{productId}";
    private static final String SAVE_BACK_ORDER_Details_URL =
            "http://localhost:8081/production/product/{productId}";

    @Autowired
    private RestTemplate restTemplate;

    public InventoryDetails getInventoryDetails(Integer productId, Integer dateId) {
        HttpEntity<?> entity = new HttpEntity<>(getHeaders());

        ResponseEntity<InventoryDetails> responseEntity =
                restTemplate.exchange(GET_PRODUCT_INVENTORY_Details_URL,
                        HttpMethod.GET,
                        entity,
                        InventoryDetails.class,
                        productId,
                        dateId);
        return responseEntity.getBody();
    }

    public ProductionDetails getProductionDetails(Integer productId) {
        HttpEntity<?> entity = new HttpEntity<>(getHeaders());

        ResponseEntity<ProductionDetails> responseEntity =
                restTemplate.exchange(GET_PRODUCT_PRODUCTION_Details_URL,
                        HttpMethod.GET,
                        entity,
                        ProductionDetails.class,
                        productId);
        return responseEntity.getBody();
    }

    public String updateBackOrderDetails(BackOrderDetails backOrderDetails) {
        HttpEntity<?> entity = new HttpEntity<>(backOrderDetails, getHeaders());

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(SAVE_BACK_ORDER_Details_URL,
                        HttpMethod.POST,
                        entity,
                        String.class);
        return responseEntity.getBody();
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

}
