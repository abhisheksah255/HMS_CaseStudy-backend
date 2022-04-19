package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhisheksah.model.Guest;

public interface Repository extends MongoRepository<Guest, Integer>{

	
}
