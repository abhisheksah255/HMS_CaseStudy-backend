package com.abhisheksah.controller;

import java.util.Date;
import java.util.List;

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

import com.abhisheksah.model.Reservation;
import com.abhisheksah.services.ReservationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/HMS/reservation")
public class ReservationController {

	private final static Logger Logger = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService;

	
	//here we are going to add the reservation and save it into the database
	@PostMapping("/addreservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
		reservation.setCheckinDate(new Date(System.currentTimeMillis()));
		Logger.info("New reservation added successfully:---"+reservation);
		return new ResponseEntity<Reservation>( reservationService.addReservation(reservation),HttpStatus.ACCEPTED);
	}
	
	//this method is call to get all the reservation into the database
	@GetMapping("/allreservation")
	public List<Reservation> getAllReservation(){
		Logger.info("found all reservation");
		return reservationService.getAllReservation();
	}

	//this method is call to get a particular data from the database
	@GetMapping("/get/{code}")
	public ResponseEntity<Reservation> getById(@PathVariable("code") int code){
		Logger.info("Reservation with id--"+code);
		return new ResponseEntity<Reservation>( reservationService.getById(code),HttpStatus.OK);
	}
	
	//this method is call to update the particular data from the database
	@PutMapping("/update/{code}")
	public ResponseEntity<Reservation> updateById(@RequestBody Reservation reservation,@PathVariable("code") int code){
		Logger.info("reservation updated Successfully with id--"+code +" and detail of updated reservation is "+reservation);
		return new ResponseEntity<Reservation>(reservationService.updateById(reservation, code),HttpStatus.ACCEPTED);
	}
	
	
	//this method is call to delete the data from the database
	@DeleteMapping("/delete/{code}")
	public ResponseEntity<String> deleteById(@PathVariable("code") int code){
	 reservationService.deleteById(code);
	 Logger.info("reservation deleted Successfully with id---"+code);
	 return new ResponseEntity<String>("Data deleted Successsfully",HttpStatus.ACCEPTED);
	}


}
