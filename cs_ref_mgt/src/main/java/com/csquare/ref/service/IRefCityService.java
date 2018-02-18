package com.csquare.ref.service;

import java.util.List;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.ref.model.RefCity;


public interface IRefCityService {

    public RefCity addRefCity(RefCity city);

    public RefCity updateRefCity(RefCity city);

    public void deleteRefCity(String studentId);

    public RefCity getRefCityById(String id);

    public List<RefCity> getAllRefCites(int offset, int limit);

    public List<RefCity> searchRefCity(List<SearchCriteria> criterias, int offset, int limit, Boolean allMatch);

}
