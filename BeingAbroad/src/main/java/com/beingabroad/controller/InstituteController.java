package com.beingabroad.controller;

import com.beingabroad.model.Institute;
import com.beingabroad.service.InstituteServiceImplemetation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/institutes")
public class InstituteController {

    @Autowired
    private InstituteServiceImplemetation instituteService;

    @PostMapping("/register")
    public ResponseEntity<Institute> registerInstitute(@Validated @RequestBody Institute institute) {
        Institute registeredInstitute = instituteService.registerInstitute(institute);
        return new ResponseEntity<>(registeredInstitute, HttpStatus.CREATED);
    }

    @PutMapping("/{instituteId}")
    public ResponseEntity<Institute> updateInstitute(
            @PathVariable Integer instituteId,
            @RequestBody Institute updatedInstitute
    ) {
        Institute updated = instituteService.updateInstitute(instituteId, updatedInstitute);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/{instituteId}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable Integer instituteId) {
        Institute institute = instituteService.getInstituteById(instituteId);
        return new ResponseEntity<>(institute, HttpStatus.OK);
    }

    
}
