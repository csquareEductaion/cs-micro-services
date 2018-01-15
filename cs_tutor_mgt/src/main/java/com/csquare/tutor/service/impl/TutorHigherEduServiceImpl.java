package com.csquare.tutor.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.csquare.tutor.dao.TutorRepository;
import com.csquare.tutor.model.Tutor;
import com.csquare.tutor.model.TutorHigherEdu;
import com.csquare.tutor.service.ITutorHigherEduService;
import com.csquare.tutor.service.ITutorService;




@Service
public class TutorHigherEduServiceImpl implements ITutorHigherEduService {

    @Autowired
    TutorRepository itutorRepository;

    @Override
    public TutorHigherEdu addTutorEdu(TutorHigherEdu tutor) {

    	String pk=UUID.randomUUID().toString();
    	tutor.setPk(pk);
        // TODO Auto-generated method stub
    	itutorRepository.save(tutor); 
        return tutor;
    }
    
    @Override
    public TutorHigherEdu updateTutorEdu(TutorHigherEdu tutor) {
	
    	itutorRepository.save(tutor);
        return tutor;
    }
    
    @Override
    public void deleteTutorEdu(String tutorId) {
	
    	itutorRepository.delete(tutorId);;
    }

    @Override
    public TutorHigherEdu getTutorEduById(String id) {
        return itutorRepository.findOne(id);
    }

	@Override
	public ArrayList<TutorHigherEdu> getAllTutorsEdu() {
		
		return (ArrayList<TutorHigherEdu>) itutorRepository.findAll();
	}
	
/*	@Override
	public ArrayList<Tutor> getAllTutors(Pageable pageable) {
		
		return (ArrayList<Tutor>) iTutorRepository.findAll(pageable);
	}*/

}
