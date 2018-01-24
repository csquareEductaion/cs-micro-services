package com.csquare.ref.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ref.dao.RefCityRepository;
import com.csquare.ref.dao.RefGradesRepository;
import com.csquare.ref.model.RefCity;
import com.csquare.ref.model.RefGrades;
import com.csquare.ref.service.IRefCityService;
import com.csquare.ref.service.IRefGradesService;



@Service
public class RefGradesServiceImpl implements IRefGradesService {

    @Autowired
    RefGradesRepository iRefGradeRepository;

    @Override
    public RefGrades addRefGrades(RefGrades grade) {

    	String pk=UUID.randomUUID().toString();
    	grade.setPk(pk);
        // TODO Auto-generated method stub
    	iRefGradeRepository.save(grade);
        return grade;
    }
    
    @Override
    public RefGrades updateRefGrades(RefGrades grade) {
	
    	iRefGradeRepository.save(grade);
        return grade;
    }
    
   

    @Override
    public RefGrades getRefGradesById(String id) {

        // TODO Auto-generated method stub
        return iRefGradeRepository.findOne(id);
    }

	@Override
	public void deleteRefGrades(String gradeId) {
		iRefGradeRepository.delete(gradeId);
		
	}

	@Override
	public List<RefGrades> getAllRefGrades() {
		// TODO Auto-generated method stub
		return iRefGradeRepository.findAll("getAllRefGread");
	}

		
}
