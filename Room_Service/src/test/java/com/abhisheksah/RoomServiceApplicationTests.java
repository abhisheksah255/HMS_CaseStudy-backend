package com.abhisheksah;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.abhisheksah.model.Room;

import com.abhisheksah.repository.RoomRepository;
import com.abhisheksah.services.RoomService;


@SpringBootTest
@RunWith(SpringRunner.class)
class RoomServiceApplicationTests {

	@MockBean
	private RoomRepository repository;

	@Autowired
	private RoomService service;
	
	@BeforeEach
	void setup() {
		Optional<Room> Room=Optional.of(new Room(1001L, "Single Bed",1200,true));
		Mockito.when(repository.findById(1001L)).thenReturn(Room);
	}
	@Test
	public void findByIdTest() {
		Room Room=repository.findById(1001L).get();
		assertEquals(1001L,Room.getRoomId());
	}
	//this is the test case for check the Room id and data store on that id 
	//getById method
	//these are the test cases for service layer 
	@Test
	public void RoomTypeTest() {
		String RoomType="Single Bed";
		Optional<Room> Room=service.getById(1001L);
		assertEquals(RoomType, Room.get().getRoomType());
		
	}
	
	@Test
	public void RoomPriceTest() {
		long price=1200;
		Optional<Room> Room=service.getById(1001L);
		assertEquals(price,Room.get().getRoomRent());
		
	}
	
	@Test
	public void deleteByRoomId() {
			long RoomId=1001L;
			Room Room=new Room(1001L, "Single Bed",1200,true);
			service.deleteRoom(RoomId);
			verify(repository, times(1)).deleteById(RoomId);
	}
	
	@Test
	public void getAllRoomTest() {
		service.getAllRoom();
		verify(repository).findAll();

	}

}
