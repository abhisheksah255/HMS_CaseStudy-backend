package com.abhisheksah.services;

import java.util.List;

import com.abhisheksah.model.Reservation;

public interface ReservationService {

	Reservation addReservation(Reservation reservation);
	
	List<Reservation> getAllReservation();
	
	Reservation getById(int code);
	
	Reservation updateById(Reservation reservation,int code);
	
	void deleteById(int code);
}
