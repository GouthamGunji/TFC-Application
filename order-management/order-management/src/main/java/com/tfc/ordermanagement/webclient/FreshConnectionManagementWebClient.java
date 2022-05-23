package com.tfc.ordermanagement.webclient;

import com.tfc.ordermanagement.model.webmodel.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FreshConnectionManagementWebClient {

    private final static String PROCESS_ORDER_URL = "http://localhost:8082/order/processorder";

    @Autowired
    private RestTemplate restTemplate;

    public Boolean processTheOrder(OrderDetails orderDetails) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(orderDetails, headers);

        return restTemplate.exchange(PROCESS_ORDER_URL,
                HttpMethod.POST,
                entity,
                Boolean.class).getBody();
    }
}
