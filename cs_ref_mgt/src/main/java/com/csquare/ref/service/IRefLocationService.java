package com.csquare.ref.service;

import com.csquare.ref.model.RefGrades;
import com.csquare.ref.model.RefLocation;


public interface IRefLocationService {

	public RefLocation addRefLocation(RefLocation grade);

    public RefLocation updateRefLocation(RefLocation grade);
    
    public void deleteRefLocation(String studentId);
    
    public RefLocation getRefLocationById(String id);
}
