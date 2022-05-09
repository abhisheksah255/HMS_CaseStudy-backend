package com.abhisheksah.services;



import java.util.List;
import java.util.Optional;

import com.abhisheksah.model.Department;










public interface Departmentservice {


	Department addDepartment(Department dept);

	List<Department> getAlldept();

	Optional<Department> getDepartment(long id);

	Department updateDepartment(Department dept,long id);

	String deleteDepartment(long id);

	

	
	
	

	
	
	

}
