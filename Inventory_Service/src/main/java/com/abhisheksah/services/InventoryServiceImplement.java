package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhisheksah.model.Inventory;
import com.abhisheksah.repository.InventoryRepository;

@Service
public class InventoryServiceImplement implements InventoryService {

	@Autowired
	private InventoryRepository repository;
	
	@Override
	public Inventory addInventory(Inventory inventory) {
		return repository.save(inventory) ;
	}

	@Override
	public List<Inventory> getAllInventory() {
		return repository.findAll();
	}

	@Override
	public Inventory updateInventory(Inventory inventory, long inventoryId) {
		inventory.setInventoryId(inventoryId);
		return repository.save(inventory);
	}

	@Override
	public void DeleteInventory(long inventoryId) {
		repository.deleteById(inventoryId);
	}

	@Override
	public Optional<Inventory> getById(long inventoryId) {
		return repository.findById(inventoryId);
	}

}
