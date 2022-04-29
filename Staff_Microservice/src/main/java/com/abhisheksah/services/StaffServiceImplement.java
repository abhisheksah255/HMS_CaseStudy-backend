package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhisheksah.model.Staff;
import com.abhisheksah.repository.StaffRepository;

@Service
public class StaffServiceImplement implements StaffService{

	@Autowired
	private StaffRepository repository;
	
	

	@Override
	public Staff addStaff(Staff staff) {
		
		return repository.save(staff);
	}

	@Override
	public List<Staff> getAllStaff() {
		return repository.findAll();
	}

	@Override
	public Staff FindByPost(String employeePost) {
		return repository.findByEmployeePost(employeePost);
	}

	@Override
	public Optional<Staff> getByStaffId(int id) {
		return repository.findById(id);
	}

	@Override
	public Staff updateById(Staff staff, int id) {
		staff.setId(id);
		
		return repository.save(staff);
	}

	@Override
	public String deleteById(int id) {
		repository.deleteById(id);
		return "data deleted Successfully"+id;
		// TODO Auto-generated method stub
		
	}

}
