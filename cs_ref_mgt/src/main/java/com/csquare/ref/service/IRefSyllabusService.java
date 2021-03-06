package com.csquare.ref.service;

import java.util.List;

import com.csquare.ref.model.RefSyllabus;


public interface IRefSyllabusService {

	public RefSyllabus addRefSyllabus(RefSyllabus grade);

    public RefSyllabus updateRefSyllabus(RefSyllabus grade);
    
    public void deleteRefSyllabus(String studentId);
    
    public RefSyllabus getRefSyllabusById(String id);
    
    public List<RefSyllabus> getAllRefSyllabus();
}
