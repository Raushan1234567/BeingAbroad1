package com.beingabroad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.beingabroad.exception.AdminAlreadyExistsException;
import com.beingabroad.exception.AdminNotFoundException;
import com.beingabroad.model.Admin;
import com.beingabroad.repository.AdminRepository;

@Service
public class AdminServiceImplementation implements AdminInterface {

   @Autowired
   private AdminRepository adminRepository;

   @Override
   public Admin registerAdmin(Admin admin) {
       Admin existingAdminOptional = adminRepository.findByEmail(admin.getEmail());

       if (existingAdminOptional!=null) {
           throw new AdminAlreadyExistsException("Admin already exists with this email: " + admin.getEmail());
       }

      
       return adminRepository.save(admin);
   }

   @Override
   public List<Admin> getAdminList() {
       List<Admin> admins = adminRepository.findAll();

       if (admins.isEmpty()) {
           throw new AdminNotFoundException("No admins found");
       }

       return admins;
   }


}
