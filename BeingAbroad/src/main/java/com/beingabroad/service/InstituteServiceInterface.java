package com.beingabroad.service;

import com.beingabroad.model.Institute;

import com.beingabroad.model.Institute;


public interface InstituteServiceInterface {
 public Institute registerInstitute(Institute institute);
 
 public Institute updateInstitute(Integer instituteId, Institute updatedInstitute);
 
 public Institute getInstituteById(Integer instituteId);
}

