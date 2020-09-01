package com.revature.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.daos.ColdStorageDao;
import com.revature.models.ColdStorage;

@Service
public class ColdStorageServiceImpl implements ColdStorageService{
	
	private ColdStorageDao csd;
	
	public ColdStorageServiceImpl(ColdStorageDao csd) {
		this.csd = csd;
	}

	@Override
	public ColdStorage getById(int id) {
		// TODO Auto-generated method stub
		return csd.getOne(id);
	}

	@Override
	public ColdStorage saveNewColdStorage(ColdStorage cs) {
		// TODO Auto-generated method stub
		return csd.save(cs);
	}

	@Override
	public List<ColdStorage> getAllColdStorage() {
		// TODO Auto-generated method stub
		return csd.findAll();
	}

}
