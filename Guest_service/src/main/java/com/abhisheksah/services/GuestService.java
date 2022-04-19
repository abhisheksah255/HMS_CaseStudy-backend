package com.abhisheksah.services;

import java.util.List;

import com.abhisheksah.model.Guest;

public interface GuestService  {

	Guest addGuest(Guest guest);
	
	List<Guest> getAllGuest();
	
	Guest getById(int id);
	
	Guest updateById(Guest guest ,int id);
	
	void deleteById(int id);
}
