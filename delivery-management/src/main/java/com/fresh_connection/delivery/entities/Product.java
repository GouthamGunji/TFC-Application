package com.fresh_connection.delivery.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTS")
	public class Product {



	@Id
	private Integer productID;
	private String productName;
	private Integer shelfLife;
	private Integer numberPerOuterBox;
	private Integer numberPerPalletLayer;
	private Integer numberPerPallet;
	private Double litersPerPack;
	private Integer salesPriceRetail;
	private Double amountOrange;
	private Double amountMango;
	private Double amountVitaminC;
	private Double amountWater;



	}
