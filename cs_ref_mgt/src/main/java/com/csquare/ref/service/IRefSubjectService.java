package com.csquare.ref.service;

import java.util.List;

import com.csquare.ref.model.RefSubject;


public interface IRefSubjectService {

    public RefSubject addRefSubject(RefSubject grade);

    public RefSubject updateRefSubject(RefSubject grade);

    public void deleteRefSubject(String studentId);

    public RefSubject getRefSubjectById(String id);

    public List<RefSubject> getAllRefSubjects();
}
