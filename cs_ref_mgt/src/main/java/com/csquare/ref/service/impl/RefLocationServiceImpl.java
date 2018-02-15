package com.csquare.ref.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ref.dao.RefLocationRepository;
import com.csquare.ref.model.RefLocation;
import com.csquare.ref.service.IRefLocationService;



@Service
public class RefLocationServiceImpl implements IRefLocationService {

    @Autowired
    RefLocationRepository iRefLocationRepository;

    @Override
    public RefLocation addRefLocation(RefLocation location) {

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
	public List<RefLocation> getAllRefLocations() {
		// TODO Auto-generated method stub
		return iRefLocationRepository.findAll();
	}
	
	@Override
	public List<RefLocation> getAllRefLocationsByCity(String city) {
		// TODO Auto-generated method stub
		return iRefLocationRepository.findAllByCity(city);
	}

	
	
}
