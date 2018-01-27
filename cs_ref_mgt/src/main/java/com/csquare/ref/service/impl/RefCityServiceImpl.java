package com.csquare.ref.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ref.dao.RefCityRepository;
import com.csquare.ref.model.RefCity;
import com.csquare.ref.service.IRefCityService;



@Service
public class RefCityServiceImpl implements IRefCityService {

    @Autowired
    RefCityRepository iRefCityRepository;

    @Override
    public RefCity addRefCity(RefCity refcity) {

//    	String pk=UUID.randomUUID().toString();
//    	refcity.setpK(pk);
        // TODO Auto-generated method stub
    	iRefCityRepository.create(refcity); 
        return refcity;
    }
    
    @Override
    public RefCity updateRefCity(RefCity refcity) {
	
    	iRefCityRepository.update(refcity);
        return refcity;
    }
    
   

    @Override
    public RefCity getRefCityById(String id) {

        // TODO Auto-generated method stub
        return iRefCityRepository.findOne(id);
    }

	@Override
	public void deleteRefCity(String cityId) {
		iRefCityRepository.delete(cityId);
		
	}

	@Override
	public List<RefCity> getAllRefCites() {
		// TODO Auto-generated method stub
		return iRefCityRepository.findAll("getAllRefCity");
	}

	
}
