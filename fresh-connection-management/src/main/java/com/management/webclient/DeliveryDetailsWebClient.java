package com.management.webclient;

import com.management.model.deliverywebmodel.DeliveryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryDetailsWebClient {

    private static final String UPDATE_DELIVERY_Details_URL =
            "http://localhost:8081/deliver/adddetails/";

    @Autowired
    private RestTemplate restTemplate;

    public String updateDeliveryDetails(DeliveryDetails deliveryDetails) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(deliveryDetails, headers);

        return restTemplate.exchange(UPDATE_DELIVERY_Details_URL,
                HttpMethod.POST,
                entity,
                String.class).getBody();
    }
}
