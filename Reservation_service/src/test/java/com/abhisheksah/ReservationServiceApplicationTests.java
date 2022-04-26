package com.abhisheksah;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.abhisheksah.exceptions.HotelException;
import com.abhisheksah.model.Reservation;
import com.abhisheksah.repository.ReservationRepository;
import com.abhisheksah.services.ReservationServiceImplement;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReservationServiceApplicationTests {

	@MockBean
	private ReservationRepository repository;
	
	@Autowired
	private ReservationServiceImplement serviceImplement;

	//this is the test for add reservation service 
	@Test
	public void addReservationTest() {
		Reservation reservation=new Reservation(101,2 , 3, null, null, "Occupied", 6);
	when(repository.save(reservation)).thenReturn(reservation);
	assertEquals(reservation,serviceImplement.addReservation(reservation));
	}
	//this is the test for get all the  reservation service 
	@Test
	public void getAllReservationTest() {
		when(repository.findAll()).thenReturn(
				Stream.of(new Reservation(101,2 , 3, null, null, "Occupied", 6),
						new Reservation(101,2 , 3, null, null, "Occupied", 6))
				.collect(Collectors.toList()));
		assertEquals(2,serviceImplement.getAllReservation().size());
		
	}
	
	//this is the test for get a particular  reservation service 
	@Test
	public void getByIdTest() {
	int code=101;
	Optional<Reservation> reservation=Optional.of(new Reservation(101,2 , 3, null, null, "Occupied", 6));
	when(repository.findById(code)).thenReturn(reservation);
	assertEquals(reservation, serviceImplement.getById(code));
	}
	
	
	//this is the test for update the particular reservation service 
	@Test
	public void updateByIdTest() {}
	
	//this is the test for delete reservation service 
	@Test
	public void deleteByIdTest() {
		int code=101;
		Optional<Reservation> reservation=Optional.of(new Reservation(code,2 , 3,null, null, "Occupied", 6));
//				.orElseThrow(() -> new HotelException("reservation", "code", code) ));
		serviceImplement.deleteById(code);
		verify(repository,times(1)).deleteById(code);
	}

}
