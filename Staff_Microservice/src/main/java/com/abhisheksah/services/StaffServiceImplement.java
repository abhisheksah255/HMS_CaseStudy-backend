package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhisheksah.exceptions.HotelException;
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
	public Optional<Staff> getByStaffId(int empId) {
		return Optional.of(repository.findById(empId).orElseThrow(()->
		new HotelException("Staff","id", empId)));
	}

	@Override
	public Staff updateById(Staff staff, int empId) {
//		staff.setEmployeeId(empId);
//		return repository.save(staff);
		Staff updatedata=repository.findById(empId).orElseThrow(()->
		new HotelException("Staff", "Id", empId));
		updatedata.setEmployeeName(staff.getEmployeeName());
		updatedata.setEmployeePost(staff.getEmployeePost());
		updatedata.setEmployeeAddress(staff.getEmployeeAddress());
		updatedata.setEmployeeSalary(staff.getEmployeeSalary());
		updatedata.setEmployeeEmail(staff.getEmployeeEmail());
		updatedata.setEmployeeGender(staff.getEmployeeGender());
		return updatedata;
	}

	@Override
	public String deleteById(int empId) {
		repository.findById(empId).orElseThrow(()-> new HotelException("staff","Id",empId ));
		repository.deleteById(empId);
		return "data deleted Successfully"+empId;
		
	}

}
