package com.abhisheksah.services;

import java.util.List;
import java.util.Optional;

import com.abhisheksah.model.Room;

public interface RoomService {

	
//to add the room into the database 	
public Room addRoom(Room room);

//get the list of room from the database
List<Room> getAllRoom();

//get the particular room by using roomId 
Optional<Room> getById(Long roomId);

//update the particular room by roomId
void updateRoom(Room room,long roomId);

//delete the room from database
void deleteRoom(long roomId);

//check the available room which are not occupied
public List<Room> getAvailableRoom(boolean roomAvailable);

}
