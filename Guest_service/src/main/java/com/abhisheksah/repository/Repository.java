package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.abhisheksah.model.Guest;

public interface Repository extends MongoRepository<Guest, Long>{

	/*
	@Query
	Guest findById(int id);
*/
}
