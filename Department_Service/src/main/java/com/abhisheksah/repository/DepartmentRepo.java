package com.abhisheksah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abhisheksah.model.Department;





@Repository
public interface DepartmentRepo extends MongoRepository<Department, Long> {

}
