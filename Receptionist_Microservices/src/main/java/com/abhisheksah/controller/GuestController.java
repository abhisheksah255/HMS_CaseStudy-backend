package com.abhisheksah.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abhisheksah.model.Guest;

@RestController
@RequestMapping("/Receptionist/guest")
public class GuestController {
	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/addguest")
	public Guest addGuest(@RequestBody Guest guest) {
		return restTemplate.postForObject("http://guest-service/HMS/guest/addguest", guest, Guest.class);
	}

	@GetMapping("/allguest")
	public List<Guest> getAllGuest() {
		return restTemplate.getForObject("http://guest-service/HMS/guest/addguest",List.class);
	}
	
	@GetMapping("/{id}")
	public Guest getById(@PathVariable int id) {
		return restTemplate.getForObject("http://guest-service/HMS/guest/"+id, Guest.class);
	}

	@PutMapping("/{id}")
	public Guest updateGuest(@RequestBody Guest guest,@PathVariable int id) {
		restTemplate.put("http://guest-service/HMS/guest/"+id,guest, Guest.class);
		return guest;
	}
	@DeleteMapping("/{id}")
	public String deleteGuest(@PathVariable int id)
	{
		restTemplate.delete("http://guest-service/HMS/guest/"+id);
	return "Guest deleted successfully:--"+id;
	}


}
