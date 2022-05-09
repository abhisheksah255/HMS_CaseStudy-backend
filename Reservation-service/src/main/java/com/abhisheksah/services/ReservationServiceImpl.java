package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.abhisheksah.model.Guest;
import com.abhisheksah.model.Reservation;
import com.abhisheksah.model.Room;
import com.abhisheksah.repository.ReservationRepository;
@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private RestTemplate restTemplate;

//	@Override
//	public String addReservation(Reservation reservation) {
//		Room room= restTemplate.getForObject("http://localhost:8084/HMS/room/get/"+reservation.getRoomId(), Room.class);
//		Guest guest=restTemplate.getForObject("http://localhost:8081/HMS/guest/get/"+reservation.getGuestId(), Guest.class);
//		if(room.isRoomAvailable()) {
//			reservationRepository.save(reservation);
//			room.setRoomAvailable(false);
//			restTemplate.put("http://localhost:8084/HMS/room/update/"+reservation.getRoomId(), room);
//			return "Room Number "+room.getRoomId()+" reserved for Guest "+guest.getGuestId();
//		}
//		else {
//			return "Room Already Booked";
//		}
//	}

	
	@Override
	public List<Reservation> getAllReservation() {
		return reservationRepository.findAll();
	}

	@Override
	public Optional<Reservation> getReservationById(long reservId) {
		return reservationRepository.findById(reservId);
	}

	@Override
	public void updateReservation(Reservation reservation, long reservId) {
		reservationRepository.save(reservation);
	}

	@Override
	public String deleteReservation(long reservId) {
		Optional<Reservation> reOptional=reservationRepository.findById(reservId);
		Reservation reservation=reOptional.get();
		Room room= restTemplate.getForObject("http://localhost:8084/HMS/room/get/"+reservation.getRoomId(), Room.class);
		room.setRoomAvailable(true);
		restTemplate.put("http://localhost:8084/HMS/room/update/"+reservation.getRoomId(), room);
		reservationRepository.deleteById(reservId);
		return "Reservation deleted for ID "+reservId;
	}

	@Override
	public String addReservation(Reservation reservation) {
		return "data save successfully " +reservationRepository.save(reservation);
	
	}
	
}
