package com.tfc.ordermanagement.dto;

import lombok.Data;

@Data
public class OrderLineItemDTO {
   private Integer productId;
   private Integer quantity;
   private Integer price;
}
