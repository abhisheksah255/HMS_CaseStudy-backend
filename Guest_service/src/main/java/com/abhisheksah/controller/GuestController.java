package com.abhisheksah.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.model.Guest;
import com.abhisheksah.services.GuestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/HMS/guest")
public class GuestController {

	
	
	private final static Logger Logger = LoggerFactory.getLogger(GuestController.class);
	
	@Autowired
	private GuestService guestservice;
	
	@PostMapping("/addguest")
	public ResponseEntity<Guest> addGuest(@Valid @RequestBody Guest guest){
		Logger.info("New guest added successfully:---"+guest);
		return new ResponseEntity<Guest>(guestservice.addGuest(guest),HttpStatus.OK);
	}

//	@PostMapping("/addguest")
//	public ResponseEntity<Guest> addGuest(@RequestBody Guest guest){
//		try {
//		guestservice.addGuest(guest);	
//		Logger.info("New guest added successfully:---"+guest);
//		return new ResponseEntity<Guest>(guest,HttpStatus.OK);
//		}catch(ConstraintViolationException e) {
//			return new ResponseEntity<Guest>(guest,HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
	
	@GetMapping("/allguest")
	public List<Guest> getAllGuest(){
		Logger.info("found all guest");
		return guestservice.getAllGuest();
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Guest>getById(@PathVariable  long id){
		Logger.info("Guest with id--"+id);
		return new ResponseEntity<Guest>(guestservice.getById(id),HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Guest>updateById(@RequestBody Guest guest,@PathVariable("id") long id){
		Logger.info("Guest updated Successfully with id--"+id +" and detail of updated guest is "+guest);
		return new ResponseEntity<Guest>(guestservice.updateById(guest, id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable long id) {
	guestservice.deleteById(id);
	Logger.info("Guest deleted Successfully with id---"+id);
	}
	
}