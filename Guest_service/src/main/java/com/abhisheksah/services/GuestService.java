package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import com.abhisheksah.model.Guest;

public interface GuestService  {

	Guest addGuest(Guest guest);
	
	List<Guest> getAllGuest();
	
	Guest getById(long id);
	
	Optional<Guest> getByGuestId(long id);
	
	Guest updateById(Guest guest ,long id);
	
	void deleteById(long id);
}
