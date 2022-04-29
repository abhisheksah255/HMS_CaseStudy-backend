package com.abhisheksah;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.abhisheksah.model.Staff;
import com.abhisheksah.repository.StaffRepository;
import com.abhisheksah.services.StaffServiceImplement;

@RunWith(SpringRunner.class)
@SpringBootTest
class StaffMicroserviceApplicationTests {




	@MockBean
	private StaffRepository repo;

	@Autowired
	private StaffServiceImplement staffImpl;
	
	
	@BeforeEach
	void setUp() {
	this.staffImpl=new StaffServiceImplement();
	}
	
	//getAllemp
	@Test
	public void getAllEmployee() {
	
		staffImpl.getAllStaff();
		verify(repo).findAll();
	
	}
	
	//getbyId
	@Test
	public void getEmp() {
	
		staffImpl.getByStaffId(1);
		verify(repo).findById(1);
	
	}
	
	//Delete
	@Test
	public void deleteEmp() {
		staffImpl.deleteById(1);
		assertThat(staffImpl.getByStaffId(1).isEmpty());
	}
	
	
	//Add
	@Test
	public void addEmp() {
		Staff staff=new Staff();
		staff.setId(1);
		staff.setEmployeeName("abhi");
		staff.setEmployeeGender("Male");
		staff.setEmployeeAddress("Lucknow");
		staff.setEmployeeEmail("abhi@gmail.com");
		staff.setEmployeePost("Cleark");
		staffImpl.addStaff(staff);
		assertNotNull(staffImpl.getByStaffId(1));
			
	}
}
