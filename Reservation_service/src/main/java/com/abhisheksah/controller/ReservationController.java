package com.abhisheksah.controller;

import java.util.Date;
import java.util.List;

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

	@Autowired
	private ReservationService reservationService;

	@PostMapping("/addreservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
		reservation.setCheckinDate(new Date(System.currentTimeMillis()));
		return new ResponseEntity<Reservation>( reservationService.addReservation(reservation),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/allreservation")
	public List<Reservation> getAllReservation(){
		return reservationService.getAllReservation();
	}

	@GetMapping("/{code}")
	public ResponseEntity<Reservation> getById(@PathVariable("code") int code){
		return new ResponseEntity<Reservation>( reservationService.getById(code),HttpStatus.OK);
	}
	
	@PutMapping("/{code}")
	public ResponseEntity<Reservation> updateById(@RequestBody Reservation reservation,@PathVariable("code") int code){
		return new ResponseEntity<Reservation>(reservationService.updateById(reservation, code),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{code}")
	public ResponseEntity<String> deleteById(@PathVariable("code") int code){
	 reservationService.deleteById(code);
	 return new ResponseEntity<String>("Data deleted Successsfully",HttpStatus.ACCEPTED);
	}


}
