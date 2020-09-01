package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ColdStorage;
import com.revature.services.ColdStorageService;

@RestController()
@RequestMapping("/coldstorage")
public class ColdStorageController {
	
	private ColdStorageService css;
	
	@Autowired
	public ColdStorageController(ColdStorageService css) {
		this.css = css;
		css.saveNewColdStorage(new ColdStorage(0,"Some Logs",-20, new Object()));
		css.saveNewColdStorage(new ColdStorage(0,"NetBeans Configuration",-100, new Object()));
		css.saveNewColdStorage(new ColdStorage(0,"2006NodeDev Recordings",-10, new Object()));
	}
	
	
	@GetMapping
	public ResponseEntity<List<ColdStorage>> getAllColdStorage(){
		return new ResponseEntity<List<ColdStorage>>(css.getAllColdStorage(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ColdStorage> saveNewColdStorage(@RequestBody ColdStorage cs) {
		if(cs.getId() != 0) {
			return new ResponseEntity("Cold Storage ID must be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(css.saveNewColdStorage(cs), HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ColdStorage> getColdStorageById(@PathVariable int id){// will try and turn the body into the object type on its right
		if(id== 0) {
			return new ResponseEntity("Cold Storage Id must not be 0", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(css.getById(id), HttpStatus.CREATED);
	}
	
	

}
