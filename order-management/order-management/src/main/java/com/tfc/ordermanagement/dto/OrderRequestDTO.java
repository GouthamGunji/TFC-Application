package com.tfc.ordermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

   private Integer customerID;
   private String status;
   private Integer orderDateId;
   private Integer deliveryDateId;
   private List<OrderLineItemDTO> orderLineItemsListDTO;



}
