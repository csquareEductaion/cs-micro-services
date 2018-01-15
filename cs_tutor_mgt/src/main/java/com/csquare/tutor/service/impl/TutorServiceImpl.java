package com.csquare.tutor.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.csquare.tutor.dao.TutorRepository;
import com.csquare.tutor.model.Tutor;
import com.csquare.tutor.service.ITutorService;




@Service
public class TutorServiceImpl implements ITutorService {

    @Autowired
    TutorRepository itutorRepository;

    @Override
    public Tutor addTutor(Tutor tutor) {

    	String pk=UUID.randomUUID().toString();
    	tutor.setpK(pk);
        // TODO Auto-generated method stub
    	itutorRepository.save(tutor); 
        return tutor;
    }
    
    @Override
    public Tutor updateTutor(Tutor tutor) {
	
    	itutorRepository.save(tutor);
        return tutor;
    }
    
    @Override
    public void deleteTutor(String tutorId) {
	
    	itutorRepository.delete(tutorId);;
    }

    @Override
    public Tutor getTutorById(String id) {
        return itutorRepository.findOne(id);
    }

	@Override
	public ArrayList<Tutor> getAllTutors() {
		
		return (ArrayList<Tutor>) itutorRepository.findAll();
	}
	
/*	@Override
	public ArrayList<Tutor> getAllTutors(Pageable pageable) {
		
		return (ArrayList<Tutor>) iTutorRepository.findAll(pageable);
	}*/

}
