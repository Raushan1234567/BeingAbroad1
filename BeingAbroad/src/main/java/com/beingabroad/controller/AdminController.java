package com.beingabroad.controller;

import com.beingabroad.model.Admin;
import com.beingabroad.repository.AdminRepository;
import com.beingabroad.service.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminInterface adminService;
    
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
	private PasswordEncoder PasswordEncoder;
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@Validated @RequestBody Admin admin) {
    	admin.setPassword( PasswordEncoder.encode(admin.getPassword()));
        Admin registeredAdmin = adminService.registerAdmin(admin);
        return new ResponseEntity<>(registeredAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Admin>> getAdminList() {
        List<Admin> admins = adminService.getAdminList();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
    
    
    @GetMapping("/logini")
	public ResponseEntity<String> logInUserHandler(Authentication auth){
		 Admin opt= adminRepository.findByEmail(auth.getName());
		 if(opt==null) throw new RuntimeException("No user found") ;
		 Admin user = opt;
		 return new ResponseEntity<>(user.getUsername()+" Logged In Successfully", HttpStatus.ACCEPTED);
	}
	
}
