package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhisheksah.model.Manager;

public interface ManagerRepository extends MongoRepository<Manager, String>{

	Manager findByEmail(String email);
}
