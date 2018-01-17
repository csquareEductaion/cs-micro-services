package com.csquare.ref.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ref.dao.RefCityRepository;
import com.csquare.ref.dao.RefGradesRepository;
import com.csquare.ref.dao.RefLocationRepository;
import com.csquare.ref.model.RefCity;
import com.csquare.ref.model.RefGrades;
import com.csquare.ref.model.RefLocation;
import com.csquare.ref.service.IRefCityService;
import com.csquare.ref.service.IRefGradesService;
import com.csquare.ref.service.IRefLocationService;



@Service
public class RefLocationServiceImpl implements IRefLocationService {

    @Autowired
    RefLocationRepository iRefLocationRepository;

    @Override
    public RefLocation addRefLocation(RefLocation location) {

    	String pk=UUID.randomUUID().toString();
    	location.setPk(pk);
        // TODO Auto-generated method stub
    	iRefLocationRepository.save(location);
        return location;
    }
    
    @Override
    public RefLocation updateRefLocation(RefLocation location) {
	
    	iRefLocationRepository.save(location);
        return location;
    }
    
   

    @Override
    public RefLocation getRefLocationById(String id) {

        // TODO Auto-generated method stub
        return iRefLocationRepository.findOne(id);
    }

	@Override
	public void deleteRefLocation(String gradeId) {
		iRefLocationRepository.delete(gradeId);
		
	}

	@Override
	public ArrayList<RefLocation> getAllRefLocations() {
		// TODO Auto-generated method stub
		return (ArrayList<RefLocation>) iRefLocationRepository.findAll();
	}

	
	
}
