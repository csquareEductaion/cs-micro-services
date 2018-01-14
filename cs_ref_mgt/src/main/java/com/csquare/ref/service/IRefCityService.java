package com.csquare.ref.service;

import com.csquare.ref.model.RefCity;

public interface IRefCityService {

    public RefCity addRefCity(RefCity city);

    public RefCity updateRefCity(RefCity city);
    
    public void deleteRefCity(String studentId);
    
    public RefCity getRefCityById(String id);

}