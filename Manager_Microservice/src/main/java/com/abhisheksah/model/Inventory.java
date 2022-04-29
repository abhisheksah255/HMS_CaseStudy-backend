package com.abhisheksah.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Inventory")
public class Inventory {

	@Id
	@NotNull(message = "It should not be null")
	private Long inventoryId;
	@Field
	private String inventoryName;
	private Long inventoryStock;
	private String inventoryType;
	
	
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Inventory(@NotNull(message = "It should not be null") Long inventoryId, String inventoryName,
			Long inventoryStock, String inventoryType) {
		super();
		this.inventoryId = inventoryId;
		this.inventoryName = inventoryName;
		this.inventoryStock = inventoryStock;
		this.inventoryType = inventoryType;
	}


	public Long getInventoryId() {
		return inventoryId;
	}


	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}


	public String getInventoryName() {
		return inventoryName;
	}


	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}


	public Long getInventoryStock() {
		return inventoryStock;
	}


	public void setInventoryStock(Long inventoryStock) {
		this.inventoryStock = inventoryStock;
	}


	public String getInventoryType() {
		return inventoryType;
	}


	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}
	
}
