package com.abhisheksah.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abhisheksah.model.Guest;
import com.abhisheksah.model.Reservation;

@RestController
@RequestMapping("/Receptionist/reservation")
public class ReservationController {

	@Autowired
	RestTemplate restTemplate;
	
	//here i am calling add reservation method from reservation service by using url with the help of rest template
	@PostMapping("/addreservation")
	public Reservation addReservation(@RequestBody Reservation reservation) {
		reservation.setCheckinDate(new Date(System.currentTimeMillis()));
		return restTemplate.postForObject("http://reservation-service/HMS/reservation/addreservation", reservation, Reservation.class);
	} 

	//here i am calling  get all reservation method from reservation service by using url with the help of rest template
	@GetMapping("/allreservation")
	public List<Reservation> getAllReservation(){
//		 Reservation reservation=
				return restTemplate.getForObject("http://reservation-service/HMS/reservation/allreservation",List.class);
//		 return reservation;
	}
	
	
	//here i am calling get particular reservation method from reservation service by using url with the help of rest template
	@GetMapping("/get/{code}")
	public Reservation getById(@PathVariable int code) {
		return restTemplate.getForObject("http://reservation-service/HMS/reservation/"+code, Reservation.class);
		
	}
	
	//here i am calling update reservation method from reservation service by using url with the help of rest template
	@PutMapping("/update/{code}")
	public Reservation updateReservation(@RequestBody Reservation reservation,@PathVariable int code) {
		restTemplate.put("http://reservation-service/HMS/reservation/"+code,reservation, Reservation.class);
		return reservation;
	}
	
	
	//here i am calling delete reservation method from reservation service by using url with the help of rest template
	@DeleteMapping("/delete/{code}")
	public String deleteReservation(@PathVariable int code) {
		restTemplate.delete("http://reservation-service/HMS/reservation/"+code);
		return "Reservation Deleted Successfully:---"+code;
	}
}

