package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhisheksah.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, Long> {

}
