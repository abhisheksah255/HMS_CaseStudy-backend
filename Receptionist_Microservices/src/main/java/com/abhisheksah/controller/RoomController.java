package com.abhisheksah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abhisheksah.model.Room;

@RestController
@RequestMapping("/Receptionist/room")
public class RoomController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/allroom")
	public List<Room> FindAllRoom() {
		return restTemplate.getForObject("http://room-service/HMS/room/allroom", List.class);
		
	}
	
	@GetMapping("/search/{roomAvailable}")
	public List<Room> getAvailableRoom(@PathVariable boolean roomAvailable){
		return restTemplate.getForObject("http://room-service/HMS/room/"+roomAvailable, List.class);
	}
	
	
}
