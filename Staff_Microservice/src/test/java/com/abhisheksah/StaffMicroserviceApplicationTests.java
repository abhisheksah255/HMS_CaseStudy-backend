package com.abhisheksah;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.abhisheksah.model.Staff;
import com.abhisheksah.repository.StaffRepository;
import com.abhisheksah.services.StaffService;
import com.mongodb.assertions.Assertions;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
class StaffMicroserviceApplicationTests {

	@MockBean
	private StaffRepository repository;

	@Autowired
	private StaffService service;
	
	/*
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setup2() {
		Staff staff=new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656);
		entityManager.persist(staff);
		}
	*/
	
	@BeforeEach
	void setup() {
		Optional<Staff> staff=Optional.of(new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656));
		Mockito.when(repository.findById(1)).thenReturn(staff);
	}
	@Test
	public void findByIdTest() {
		Staff staff=repository.findById(1).get();
		assertEquals("abhi@gmail.com",staff.getEmployeeEmail());
	}
	//this is the test case for check the staff id and data store on that id 
	//getById method
	//these are the test cases for service layer 
	@Test
	public void StaffNameTest() {
		String employee_name="Abhishek";
		Optional<Staff> staffId=service.getByStaffId(1);
		assertEquals(employee_name, staffId.get().getEmployeeName());
		
	}
	
	@Test
	public void StaffAddressTest() {
		String employee_address="Lucknow";
		Optional<Staff> staffId=service.getByStaffId(1);
		assertEquals(employee_address, staffId.get().getEmployeeAddress());
		
	}
	
	// getAllemp
	@Test
	public void getAllEmployee() {
		service.getAllStaff();
		verify(repository).findAll();

	}
	
	//this is also the same method to check all staff 

	@Test
	public void getAllEmployeeBySizTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656),
						new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllStaff().size());
	}
	
	//this is the test for add the staff 
	@Test
	public void addStafftest() {
	Staff staff=new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656);
	when(repository.save(staff)).thenReturn(staff);
	assertEquals(staff,service.addStaff(staff));
	}

	//get by post
//	@Test
//	public void getByPostTest() {
//		String post="manager";
//		when(repository.findByEmployeePost(post)).thenReturn((Staff) Stream
//				.of(new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656))
//				.collect(Collectors.toList()));
//		assertEquals(1,((List<Staff>) service.FindByPost(post)).size());
//	}
//	
	//this is for update staff test case
	
	
	@Test
	public void updatestaffTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656))
				.collect(Collectors.toList()));
//	Staff staff=new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656);
//		staff =repository.findById(123).get();
//		staff.setEmployeeEmail("abhishek@gmail.com");
//		Staff updatestaff=repository.save(staff);
//		assertThat(updatestaff.getEmployeeEmail()).isEqualTo("abhishek@gmail.com");
//		
	}


	@Test
	public void deletetest() {
		Staff staff = new Staff();
		staff.setEmployeeName("Abhishek");
		staff.setEmployeeId(123);;
		when(repository.findById(staff.getEmployeeId())).thenReturn(Optional.of(staff));
		service.deleteById(staff.getEmployeeId());
		verify(repository).deleteById(staff.getEmployeeId());
		}
	/*
	@Test
	public void updatetestdetail() {
		 Staff staff=new Staff(123, "Abhishek", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656);
		 Staff newStaff=new Staff(123, "Rahul", "Lucknow", "abhi@gmail.com", "Male", "Manager", 567656);
		
		 
		 when(repository.findById(staff.getEmployeeId())).thenReturn(Optional.of(staff));
		 service.updateById(newStaff,123);
		 verify(repository).save(newStaff);
		 verify(repository).findById(staff.getEmployeeId());
	}
	*/
	
}

