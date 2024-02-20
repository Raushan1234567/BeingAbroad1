package com.beingabroad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beingabroad.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	 public Admin findByEmail(String email);
}
