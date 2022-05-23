package com.fresh_connection.delivery.dto;

public class DeliveryDTO {
	
		private Long productId;

		private Long customerId;

		private Long dateId;

		private Long delivery;

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public Long getDateId() {
			return dateId;
		}

		public void setDateId(Long dateId) {
			this.dateId = dateId;
		}

		public Long getDelivery() {
			return delivery;
		}

		public void setDelivery(Long delivery) {
			this.delivery = delivery;
		}
		

}
