package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.abhisheksah.exceptions.HotelException;
import com.abhisheksah.model.Guest;
import com.abhisheksah.repository.Repository;

@Service
public class GuestServiceImplement implements GuestService{

	@Autowired
	private	Repository repository;
	
	public GuestServiceImplement(Repository repository) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Guest addGuest(Guest guest ){
		return repository.save(guest);
	}


//	@Override
//	public Guest addGuest(Guest guest )throws ConstraintViolationException{
//		return repository.save(guest);
//	}
//	
//	
	@Override
	public List<Guest> getAllGuest() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
	@Override
	public Guest getById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.orElseThrow(()->new HotelException("Guest", "id", id));
	}
	
	
	public Optional<Guest> getByGuestId(long id){
		return repository.findById(id);
	}
	

	@Override
	public Guest updateById(Guest guest, long id) {
		// TODO Auto-generated method stub
		
		Guest updateguestdata= repository.findById(id)
				.orElseThrow(()->new HotelException("Guest","id",id));
		updateguestdata.setPhoneNumber(guest.getPhoneNumber());
		repository.save(updateguestdata);
		return updateguestdata ;
	}

	@Override
	public  void  deleteById(long id) {
		repository.deleteById(id);
		repository.findById(id);
//		.orElseThrow(()->new HotelException("Guest", "id", id));
		
	}

	

}
