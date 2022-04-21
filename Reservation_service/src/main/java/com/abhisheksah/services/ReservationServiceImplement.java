package com.abhisheksah.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhisheksah.exceptions.HotelException;
import com.abhisheksah.model.Reservation;
import com.abhisheksah.repository.ReservationRepository;

@Service
public class ReservationServiceImplement implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public Reservation addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getById(int code) {
		// TODO Auto-generated method stub
		return reservationRepository.findById(code).orElseThrow(()-> new HotelException("Reservation ","id", code));
	}

	@Override
	public Reservation updateById(Reservation reservation, int code) {
		Reservation updatedata=reservationRepository.findById(code).orElseThrow(()-> new HotelException("Reservation", "id", code));
		updatedata.setStatus(reservation.getStatus());
		updatedata.setCheckinDate(new Date(System.currentTimeMillis()));
		updatedata.setNumberofnights(reservation.getNumberofnights());
		reservationRepository.save(updatedata);
		return  updatedata;
	}

	@Override
	public void deleteById(int code) {
		// TODO Auto-generated method stub
		reservationRepository.deleteById(code);
		 reservationRepository.findById(code).orElseThrow(()-> new HotelException("Reservation ","id", code));
	}

}
