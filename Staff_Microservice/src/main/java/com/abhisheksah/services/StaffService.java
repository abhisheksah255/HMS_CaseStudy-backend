package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import com.abhisheksah.model.Staff;

public interface StaffService {

	Staff addStaff(Staff staff);
	List<Staff> getAllStaff();
	

	Optional<Staff> getByStaffId(int id);
	
	Staff updateById(Staff staff,int id);
	String deleteById(int id);
	Staff FindByPost(String employeePost);
}
