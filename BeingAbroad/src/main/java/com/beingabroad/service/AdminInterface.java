package com.beingabroad.service;

import java.util.List;

import com.beingabroad.model.Admin;

public interface AdminInterface {
	
	public Admin registerAdmin(Admin admin);
	
	public List<Admin> getAdminList();

}
