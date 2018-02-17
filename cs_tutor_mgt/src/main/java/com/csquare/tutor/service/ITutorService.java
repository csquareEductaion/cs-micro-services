package com.csquare.tutor.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.csquare.tutor.model.Tutor;


public interface ITutorService {

    public Tutor addTutor(Tutor lead);

    public Tutor updateTutor(Tutor lead);
    
    public void deleteTutor(String leadId);
    
    public Tutor getTutorById(String id);
    
    public List<Tutor> getAllTutors();
    
    public List<Tutor> getAllLeads(int offset, int limit);
    
    public List<Tutor> getAllTutorsByParams(Tutor tutor);
    
    
  // public List<Tutor> getAllTutorsByParams(More Optional arguments  String firstName)

}
