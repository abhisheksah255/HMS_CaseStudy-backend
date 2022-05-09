package com.abhisheksah.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.model.Staff;
import com.abhisheksah.repository.StaffRepository;
import com.abhisheksah.services.StaffService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/HMS/staff")
public class StaffController {
	
	private final static Logger Logger = LoggerFactory.getLogger(StaffController.class);


	@Autowired
	private StaffService service;
	
//	@Autowired
//	private StaffRepository repository;
	
	//here i am call add staff method to add the staff into the database
	@PostMapping("/addstaff")
	public ResponseEntity<Staff> addStaff(@RequestBody Staff staff){
		Logger.info("new Staff added successfully"+staff);
		return new ResponseEntity<Staff>(service.addStaff(staff),HttpStatus.ACCEPTED);
	}
	
	//this is the method to show all the staff present into the database
	@GetMapping("/allstaff")
	public List<Staff> getAllStaff(){
		Logger.info("Get All Staff ");
		return service.getAllStaff();
	}
	
//	@GetMapping("/get/{employeePost}")
//	public ResponseEntity<Staff> findByPost(@PathVariable("employeePost") String employeePost){
//		//Logger.info("Get particular Staff by their Id:--");
//	return new ResponseEntity<Staff>(service.FindByPost(employeePost),HttpStatus.OK);
//	}
	
	@GetMapping("/get/{empId}")
	public Optional<Staff> getByStaffId(@PathVariable("empId") int empId){
		Logger.info("Get particular Staff details by their post:--");
		return service.getByStaffId(empId);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<Staff> updateStaffById(@RequestBody Staff staff , @PathVariable int empId){
		Logger.info("update particular staff by their id:--");
	return new ResponseEntity<Staff>(service.updateById(staff, empId),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{empId}")
	public String deleteStaffById(@PathVariable ("empId") int empId){
		Logger.info("delete the particular Staff by their id");
	return service.deleteById(empId);
	}
}
