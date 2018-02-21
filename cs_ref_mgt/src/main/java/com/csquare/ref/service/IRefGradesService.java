package com.csquare.ref.service;

import java.util.List;

import com.csquare.ref.model.RefGrades;


public interface IRefGradesService {

    public RefGrades addRefGrades(RefGrades grade);

    public RefGrades updateRefGrades(RefGrades grade);

    public void deleteRefGrades(String studentId);

    public RefGrades getRefGradesById(String id);

    public List<RefGrades> getAllRefGrades();
}
