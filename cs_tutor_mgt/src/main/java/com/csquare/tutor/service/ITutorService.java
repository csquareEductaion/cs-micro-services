package com.csquare.tutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.csquare.tutor.model.Tutor;


public interface ITutorService {

    public Tutor addTutor(Tutor lead);

    public Tutor updateTutor(Tutor lead);
    
    public void deleteTutor(String leadId);
    
    public Tutor getTutorById(String id);
    
    public ArrayList<Tutor> getAllTutors();
    
   // public ArrayList<Lead> getAllLeads(Pageable pageable);

}
