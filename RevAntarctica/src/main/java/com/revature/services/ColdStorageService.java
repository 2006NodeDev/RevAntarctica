package com.revature.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.revature.models.ColdStorage;

public interface ColdStorageService {

	ColdStorage getById(int id);

	ColdStorage saveNewColdStorage(ColdStorage cs);

	List<ColdStorage> getAllColdStorage();

}
