package com.abhisheksah.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.abhisheksah.model.Room;

public interface RoomRepository extends MongoRepository<Room, Long> {

	@Query
	public List<Room> findByRoomAvailable(boolean roomAvailable);
	
}
