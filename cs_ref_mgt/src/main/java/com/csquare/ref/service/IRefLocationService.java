package com.csquare.ref.service;

import java.util.List;

import com.csquare.ref.model.RefLocation;


public interface IRefLocationService {

	public RefLocation addRefLocation(RefLocation grade);

    public RefLocation updateRefLocation(RefLocation grade);
    
    public void deleteRefLocation(String studentId);
    
    public RefLocation getRefLocationById(String id);
    
    public List<RefLocation> getAllRefLocations();
}
