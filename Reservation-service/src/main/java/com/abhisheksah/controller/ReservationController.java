package com.abhisheksah.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.abhisheksah.model.Room;
import com.abhisheksah.services.ReservationServiceImpl;

//import io.swagger.annotations.ApiOperation;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/HMS/reservation")
public class ReservationController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ReservationServiceImpl reservationService;
	
//	@PostMapping("/addreservation")
//	@ApiOperation(value = "Adding Reservation Details")
//	public String addReservation(@RequestBody Reservation reservation) {
//		return this.reservationService.addReservation(reservation);
//	}
	
	@GetMapping("/allreservation")
//	@ApiOperation(value = "Views all Reservation Details")
	public List<Reservation> getAllReservation(){
		return this.reservationService.getAllReservation();
	}
	
	@GetMapping("/get/{reservationId}")
//	@ApiOperation(value = "Views Specific Reservation Details using ID")
	public Optional<Reservation> getReservationById(@PathVariable long resId){
		return this.reservationService.getReservationById(resId);
	}
	
	@PutMapping("/update/{reservationId}")
//	@ApiOperation(value = "Upadtes the Reservation Details of given ID")
	public String updateReservation (@RequestBody Reservation reservation,@PathVariable long resId) {
		this.reservationService.updateReservation(reservation, resId);
		return "Reservation updated for ID "+resId;
	}
	
	@DeleteMapping("/delete/{reservationId}")
//	@ApiOperation(value = "Deletes the Reservation Details of given ID")
	public String deleteReservation(@PathVariable long reservationId) {
		return this.reservationService.deleteReservation(reservationId);
	}
	
	@PostMapping("/allreservation")
	public String addReservation(@RequestBody Reservation reservation) {
	Room room=restTemplate.getForObject("http://localhost:8084/HMS/room/get/"+reservation.getRoomId(), Room.class);
	Guest guest=restTemplate.getForObject("http://localhost:8081/HMS/guest/get/"+reservation.getGuestId(), Guest.class);
	if(room.isRoomAvailable()) {
		reservationService.addReservation(reservation);
		room.setRoomAvailable(false);
		restTemplate.put("http://localhost:8084/HMS/room/update/"+reservation.getRoomId(), room);
		return "Room Number "+room.getRoomId()+"reserved for guest"+guest.getGuestId();
	}
	else {
		return "Room Already Booked";
	}
}


}
