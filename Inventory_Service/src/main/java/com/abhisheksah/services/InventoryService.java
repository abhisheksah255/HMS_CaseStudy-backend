package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import com.abhisheksah.model.Inventory;

public interface InventoryService {

	Inventory addInventory(Inventory inventory);
	
	List<Inventory> getAllInventory();
	
	Optional<Inventory> getById(long inventoryId);
	
	Inventory updateInventory(Inventory inventory,long inventoryId);
	
	void DeleteInventory(long inventoryId);

}
