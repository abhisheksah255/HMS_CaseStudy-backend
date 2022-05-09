package com.abhisheksah;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.abhisheksah.model.Inventory;
import com.abhisheksah.repository.InventoryRepository;
import com.abhisheksah.services.InventoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
class InventoryServiceApplicationTests {

	@MockBean
	private InventoryRepository repository;

	@Autowired
	private InventoryService service;
	
	@BeforeEach
	void setup() {
		Optional<Inventory> inventory=Optional.of(new Inventory(123L,"RoomKey",89L,"lock"));
		Mockito.when(repository.findById(123L)).thenReturn(inventory);
	}
	@Test
	public void findByIdTest() {
		Inventory inventory=repository.findById(123L).get();
		assertEquals("RoomKey",inventory.getInventoryName());
	}
	//this is the test case for check the inventory id and data store on that id 
	//getById method
	//these are the test cases for service layer 
	@Test
	public void InventoryNameTest() {
		String inventory_name="RoomKey";
		Optional<Inventory> inventory=service.getById(123L);
		assertEquals(inventory_name, inventory.get().getInventoryName());
		
	}
	
	@Test
	public void inventoryTypeTest() {
		String inventoryType="lock";
		Optional<Inventory> inventory=service.getById(123L);
		assertEquals(inventoryType,inventory.get().getInventoryType());
		
	}
	
	@Test
	public void deleteById() {
			long InventoryId=123L;
			Inventory inventory=new Inventory(123L,"RoomKey",89L,"lock");
			service.DeleteInventory(InventoryId);
			verify(repository, times(1)).deleteById(InventoryId);
	}
	
	@Test
	public void getAllInventoryTest() {
		service.getAllInventory();
		verify(repository).findAll();

	}
}
