package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abhisheksah.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	User findByUsername(String username);

}
