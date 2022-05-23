package com.tfc.ordermanagement.service;

import com.tfc.ordermanagement.dto.OrderLineItemDTO;
import com.tfc.ordermanagement.dto.OrderRequestDTO;
import com.tfc.ordermanagement.exception.OrderNotProcessedException;
import com.tfc.ordermanagement.model.OrderHeader;
import com.tfc.ordermanagement.model.OrderLineItem;
import com.tfc.ordermanagement.model.webmodel.OrderDetails;
import com.tfc.ordermanagement.repository.CustomerRepository;
import com.tfc.ordermanagement.repository.DateModelRepository;
import com.tfc.ordermanagement.repository.OrderHeaderRepository;
import com.tfc.ordermanagement.repository.OrderLineItemRepository;
import com.tfc.ordermanagement.webclient.FreshConnectionManagementWebClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private OrderLineItemRepository orderLineItemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DateModelRepository dateModelRepository;

    @Autowired
    private FreshConnectionManagementWebClient freshConnectionManagementWebClient;

    @Transactional
    public String createOrder(OrderRequestDTO orderRequestDTO) throws OrderNotProcessedException {
        //save the Order lines into DB
        List<OrderLineItem> orderLineItems =
                getOrderLineItemsFromDTO(orderRequestDTO.getOrderLineItemsListDTO());

        saveOrderLineItemsIntoDB(orderLineItems);

        //save the OrderHeader
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomerId(customerRepository.getById(orderRequestDTO.getCustomerID()));
        orderHeader.setOrderDateId(dateModelRepository.getById(orderRequestDTO.getOrderDateId()));
        orderHeader.setDeliveryDateId(dateModelRepository.getById(orderRequestDTO.getDeliveryDateId()));
        orderHeader.setOrderLineItems(orderLineItems);
        orderHeader.setStatus("Initialised");

        orderHeaderRepository.save(orderHeader);
        return "Order placed  successfully";
    }

    private void saveOrderLineItemsIntoDB(List<OrderLineItem> orderLineItems) {
        for (OrderLineItem orderLineItem : orderLineItems) {
            orderLineItemRepository.save(orderLineItem);
        }
    }

    private List<OrderLineItem> getOrderLineItemsFromDTO(List<OrderLineItemDTO> orderLineItemsListDTO) {
        return orderLineItemsListDTO
                .stream()
                .map(orderLineDto -> {
                    OrderLineItem orderItem = new OrderLineItem();
                    BeanUtils.copyProperties(orderLineDto, orderItem);
                    return orderItem;
                }).collect(Collectors.toList());
    }

    public String processTheOrder(Integer orderId) throws OrderNotProcessedException {
        OrderHeader orderHeader = orderHeaderRepository.findById(orderId).get();
        OrderDetails orderDetails = getOrderDetailsWebModel(orderHeader);
        Boolean webResponse = freshConnectionManagementWebClient.processTheOrder(orderDetails);
        //System.out.println("web client response " + webResponse);
        if (webResponse) {
            orderHeader.setStatus("Processed");
            orderHeaderRepository.save(orderHeader);
            return "Order is processed succesfully";
        }
        throw new OrderNotProcessedException("Something went Wrong !!, Order not able to processed");
    }

    private OrderDetails getOrderDetailsWebModel(OrderHeader orderHeader) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrderId(orderHeader.getOrderId());
        orderDetails.setCustomerID(orderHeader.getCustomerId().getCustomerID());
        orderDetails.setOrderDateId(orderHeader.getOrderDateId().getDateID());
        orderDetails.setDeliveryDateId(orderHeader.getDeliveryDateId().getDateID());
        orderDetails.setOrderLineItems(orderHeader.getOrderLineItems());
        return orderDetails;
    }
}
