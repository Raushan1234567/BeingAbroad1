package com.beingabroad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beingabroad.model.Institute;



public interface InstituteRepository extends JpaRepository<Institute, Integer> {
	
}

