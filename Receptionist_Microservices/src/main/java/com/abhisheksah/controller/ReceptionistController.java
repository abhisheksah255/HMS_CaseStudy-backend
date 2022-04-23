package com.abhisheksah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.exceptions.HotelException;
import com.abhisheksah.model.Receptionist;
import com.abhisheksah.repository.ReceptionistRepository;
import com.abhisheksah.services.ReceptionistService;

@RestController
@RequestMapping("/Receptionist")
public class ReceptionistController {

	@Autowired
	private ReceptionistRepository receptionistRepository;
	@Autowired
	private ReceptionistService receptionistService;
	@Autowired
	private AuthenticationManager authenticationManager;


	@PostMapping("/addReceptonist")
	private ResponseEntity<?> addReceptionist(@RequestBody Receptionist receptionist){
		
		String email=receptionist.getEmail();
		String password=receptionist.getPassword();
		Receptionist updateReceptionist=new Receptionist();
		updateReceptionist.setEmail(email);
		updateReceptionist.setPassword(password);
		
		try {
			receptionistRepository.save(receptionist);
		} catch (Exception e) {
			return ResponseEntity.ok(new HotelException("error on creating Receptionist:-","email:--", email));
		}
		return ResponseEntity.ok(new HotelException("Successfully created Receptionist:-",email, password));
	
	}
	
	@GetMapping("/allReceptionist")
	public List<Receptionist> getAllReceptionist(){
		return receptionistService.getReceptionist();
	}

	
	@PostMapping("/authenticate")
	private ResponseEntity<?> authenticateReceptionist(@RequestBody Receptionist receptionist){
		
		String email=receptionist.getEmail();
		String password=receptionist.getPassword();
		try {
			receptionistRepository.save(receptionist);
		} catch (Exception e) {
			return ResponseEntity.ok(new HotelException("error on creating Receptionist:-","email:--", email));
		}
		return ResponseEntity.ok(new HotelException("Successfully created Receptionist:-",email, password));
	
	}
	

}
