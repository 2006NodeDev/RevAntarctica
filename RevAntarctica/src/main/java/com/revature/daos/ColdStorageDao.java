package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.ColdStorage;

@Repository
public interface ColdStorageDao extends JpaRepository<ColdStorage, Integer>{

}
