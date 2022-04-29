package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhisheksah.model.Staff;

@Repository
public interface StaffRepository extends MongoRepository<Staff,Integer> {

	@Query
	Staff findByEmployeePost(String employeePost);
	
	
}
