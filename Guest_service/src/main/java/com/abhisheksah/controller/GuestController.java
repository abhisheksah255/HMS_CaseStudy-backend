package com.abhisheksah.controller;

import java.util.List;

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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/HMS/guest")
public class GuestController {

	@Autowired
	private GuestService guestservice;
	
	@PostMapping("/addguest")
	public ResponseEntity<Guest> addGuest(@RequestBody Guest guest){
		return new ResponseEntity<Guest>(guestservice.addGuest(guest),HttpStatus.OK);
	}

	@GetMapping("/allguest")
	public List<Guest> getAllGuest(){
		return guestservice.getAllGuest();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Guest>getById(@PathVariable  int id){
		return new ResponseEntity<Guest>(guestservice.getById(id),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Guest>updateById(@RequestBody Guest guest,@PathVariable("id") int id){
		return new ResponseEntity<Guest>(guestservice.updateById(guest, id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
	guestservice.deleteById(id);	
	}
	
}