package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhisheksah.model.Receptionist;

public interface ReceptionistRepository extends MongoRepository<Receptionist, String>{

	Receptionist findByEmail(String email);
}
