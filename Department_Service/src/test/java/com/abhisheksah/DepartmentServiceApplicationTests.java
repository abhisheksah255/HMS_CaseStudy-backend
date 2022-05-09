package com.abhisheksah;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.abhisheksah.model.Department;
import com.abhisheksah.repository.DepartmentRepo;
import com.abhisheksah.services.Departmentservice;

@SpringBootTest
class DepartmentServiceApplicationTests {

	@MockBean
	private DepartmentRepo repository;

	@Autowired
	private Departmentservice service;
	
	@BeforeEach
	void setup() {
		Optional<Department> Department=Optional.of(new Department(123L,"Account","this is all account dept.",4));
		Mockito.when(repository.findById(123L)).thenReturn(Department);
	}
	@Test
	public void findByIdTest() {
		Department Department=repository.findById(123L).get();
		assertEquals(123L,Department.getDepartmentID());
	}
	//this is the test case for check the Department id and data store on that id 
	//getById method
	//these are the test cases for service layer 
	@Test
	public void DepartmentNameTest() {
		String DepartmentName="Account";
		Optional<Department> Department=service.getDepartment(123L);
		assertEquals(DepartmentName, Department.get().getDepartmentName());
		
	}
	
	@Test
	public void DepartmentDescTest() {
		String DepartmentDes="this is all account dept.";
		Optional<Department> Department=service.getDepartment(123L);
		assertEquals(DepartmentDes,Department.get().getDesc());
		
	}
	
	@Test
	public void deleteByDepartmentId() {
			long DepartmentId=123L;
			Department Department=new Department(123L,"Account","this is all account dept.",4);
			service.deleteDepartment(DepartmentId);
			verify(repository, times(1)).deleteById(DepartmentId);
	}
	
	@Test
	public void getAllDepartmentTest() {
		service.getAlldept();
		verify(repository).findAll();

	}
}
