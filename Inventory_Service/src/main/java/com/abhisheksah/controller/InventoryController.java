package com.abhisheksah.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksah.model.Inventory;
import com.abhisheksah.services.InventoryService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/HMS/inventory")
public class InventoryController {

	private final static Logger Logger = LoggerFactory.getLogger(InventoryController.class);

	
	@Autowired
	private InventoryService service;

	@PostMapping("/addinventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory ){
		String methodName="addInventory()";
		Logger.info(methodName+ " called successfully");
		Inventory inv=this.service.addInventory(inventory);
		if(inv==null) {
			return null;
		}
		return new ResponseEntity<Inventory>(inv,HttpStatus.OK);
	}
	
	@GetMapping("/allinventory")
	public List<Inventory> getAllData(){
		Logger.info("Get all method called :--");
		return service.getAllInventory();
	}
	@GetMapping("/get/{inventoryId}")
	public Optional<Inventory> getById(@PathVariable("inventoryId") long inventoryId){
		return this.service.getById(inventoryId);
	} 

	@PutMapping("/update/{inventoryId}")
	public ResponseEntity<Inventory> updateinventory(@RequestBody Inventory inv, @PathVariable long inventoryId){
		Logger.info("update method called :--");
		return new ResponseEntity<Inventory>(service.updateInventory(inv, inventoryId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{inventoryId}")
	public ResponseEntity<String> deleteData(@PathVariable long inventoryId){
		service.DeleteInventory(inventoryId);
		Logger.info("Delete method called :--");
		return new ResponseEntity<String>("Id deleted successfully",HttpStatus.ACCEPTED);
	}
}
