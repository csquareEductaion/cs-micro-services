package com.csquare.ref.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.ref.dao.RefCityRepository;
import com.csquare.ref.model.RefCity;
import com.csquare.ref.service.IRefCityService;


@Service
public class RefCityServiceImpl implements IRefCityService {

    @Autowired
    RefCityRepository iRefCityRepository;

    @Override
    public RefCity addRefCity(RefCity refcity) {

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

        return iRefCityRepository.findOne(id);
    }

    @Override
    public void deleteRefCity(String cityId) {

        iRefCityRepository.delete(cityId);

    }

    @Override
    public List<RefCity> getAllRefCites(int offset, int limit) {

        return iRefCityRepository.findAll();
    }

    @Override
    public List<RefCity> searchRefCity(List<SearchCriteria> criterias, int offset, int limit, Boolean allMatch) {

        List<RefCity> refCityList = iRefCityRepository.search(criterias, offset, limit, allMatch);
        return refCityList;
    }
}
