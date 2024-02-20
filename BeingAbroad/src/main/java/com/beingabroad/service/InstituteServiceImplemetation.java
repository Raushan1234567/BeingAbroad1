package com.beingabroad.service;

import com.beingabroad.exception.InstituteAlreadyExistsException;
import com.beingabroad.exception.InstituteNotFoundException;
import com.beingabroad.model.Institute;
import com.beingabroad.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstituteServiceImplemetation implements InstituteServiceInterface {

    @Autowired
    private InstituteRepository instituteRepository;

    @Override
    public Institute registerInstitute(Institute institute) {
        
    	Optional<Institute> existsOrNot=instituteRepository.findById(institute.getId());
    	
        if (existsOrNot.isPresent()) {
            throw new InstituteAlreadyExistsException("Institute with id '" + institute.getId() + "' already exists");
        }

        return instituteRepository.save(institute);
    }
    
    @Override
    public Institute updateInstitute(Integer instituteId, Institute updatedInstitute) {

        Optional<Institute> optionalExistingInstitute = instituteRepository.findById(instituteId);

        if (optionalExistingInstitute.isEmpty()) {
            throw new InstituteNotFoundException("Institute with ID " + instituteId + " not found");
        }

        Institute existingInstitute = optionalExistingInstitute.get();
        existingInstitute.setName(updatedInstitute.getName());
        existingInstitute.setLocation(updatedInstitute.getLocation());
        existingInstitute.setContactInfo(updatedInstitute.getContactInfo());

        return instituteRepository.save(existingInstitute);
    }


    @Override
    public Institute getInstituteById(Integer instituteId) {
      
        Optional<Institute> optionalInstitute = instituteRepository.findById(instituteId);
        if (optionalInstitute.isPresent()) {
            return optionalInstitute.get();
        } else {
            throw new InstituteNotFoundException("Institute with ID " + instituteId + " not found");
        }
    }
}
