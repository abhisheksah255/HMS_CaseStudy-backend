package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhisheksah.model.Room;
import com.abhisheksah.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository repository;
	
	@Override
	public Room addRoom(Room room) {
		return repository.save(room); 
	}

	@Override
	public List<Room> getAllRoom() {
	// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<Room> getById(Long roomId) {
		// TODO Auto-generated method stub
		return repository.findById(roomId);
	}

	@Override
	public void updateRoom(Room room, long roomId) {
		// TODO Auto-generated method stub
		repository.save(room);
	}

	@Override
	public void deleteRoom(long roomId) {
		// TODO Auto-generated method stub
		repository.deleteById(roomId);
	}

	@Override
	public List<Room> getAvailableRoom(boolean roomAvailable) {
		// TODO Auto-generated method stub
		return repository.findByRoomAvailable(roomAvailable);
	}

}
