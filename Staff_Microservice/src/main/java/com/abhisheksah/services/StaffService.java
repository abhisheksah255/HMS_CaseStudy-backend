package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import com.abhisheksah.model.Staff;

public interface StaffService {

	Staff addStaff(Staff staff);
	List<Staff> getAllStaff();
	

	Optional<Staff> getByStaffId(int empId);
	
	Staff updateById(Staff staff,int empId);
	String deleteById(int empId);
	Staff FindByPost(String employeePost);
}
