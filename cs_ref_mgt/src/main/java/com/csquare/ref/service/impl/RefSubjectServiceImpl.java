package com.csquare.ref.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ref.dao.RefSubjectRepository;
import com.csquare.ref.model.RefSubject;
import com.csquare.ref.service.IRefSubjectService;



@Service
public class RefSubjectServiceImpl implements IRefSubjectService {

    @Autowired
    RefSubjectRepository iRefLocationRepository;

    @Override
    public RefSubject addRefSubject(RefSubject refsub) {

        // TODO Auto-generated method stub
    	iRefLocationRepository.create(refsub);
        return refsub;
    }
    
    @Override
    public RefSubject updateRefSubject(RefSubject refsub) {
	
    	iRefLocationRepository.update(refsub);
        return refsub;
    }
    
   

    @Override
    public RefSubject getRefSubjectById(String id) {

        // TODO Auto-generated method stub
        return iRefLocationRepository.findOne(id);
    }

	@Override
	public void deleteRefSubject(String refsubId) {
		iRefLocationRepository.delete(refsubId);
		
	}

	@Override
	public List<RefSubject> getAllRefSubjects() {
		// TODO Auto-generated method stub
		return iRefLocationRepository.findAll("getAllRefSubject");
	}

	
	
}
