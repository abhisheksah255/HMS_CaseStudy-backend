package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhisheksah.model.Department;
import com.abhisheksah.repository.DepartmentRepo;


@Service
public class DepartmentserviceImpl implements Departmentservice {

	@Autowired
	private DepartmentRepo repo;

	@Override
	public Department addDepartment(Department dept) {
		// TODO Auto-generated method stub
		return repo.save(dept);
	}

	@Override
	public List<Department> getAlldept() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Department> getDepartment(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Department updateDepartment(Department dept, long id) {
		dept.setDepartmentID(id);
		return repo.save(dept);
	}

	@Override
	public String deleteDepartment(long id) {
		repo.deleteById(id);
		return "Department Deleted";
	}
	
	
	 


}

	
	
	
	

