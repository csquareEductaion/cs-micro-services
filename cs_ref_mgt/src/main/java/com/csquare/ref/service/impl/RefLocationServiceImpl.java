package com.csquare.ref.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.framework.util.StringUtil;
import com.csquare.ref.dao.RefLocationRepository;
import com.csquare.ref.model.NamedQueryConstants;
import com.csquare.ref.model.RefLocation;
import com.csquare.ref.service.IRefLocationService;


@Service
public class RefLocationServiceImpl implements IRefLocationService {

    @Autowired
    RefLocationRepository iRefLocationRepository;
    

    @Override
    public RefLocation addRefLocation(RefLocation location) {

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

        return iRefLocationRepository.findOne(id);
    }

    @Override
    public void deleteRefLocation(String gradeId) {

        iRefLocationRepository.delete(gradeId);

    }

    @Override
    public List<RefLocation> getAllRefLocations() {

        return iRefLocationRepository.findAll();
    }

	@Override
	public List<RefLocation> searchLocationByCity(String city) {
		// TODO Auto-generated method stub
		
				SearchCriteria sc=new SearchCriteria();
		sc.setFieldName("city");
		sc.setFieldValue(city);
		
		return iRefLocationRepository.search(sc, -1, -1,true);
	}

}
