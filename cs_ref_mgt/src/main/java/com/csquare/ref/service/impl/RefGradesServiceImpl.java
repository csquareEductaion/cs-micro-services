package com.csquare.ref.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ref.dao.RefGradesRepository;
import com.csquare.ref.model.RefGrades;
import com.csquare.ref.service.IRefGradesService;


@Service
public class RefGradesServiceImpl implements IRefGradesService {

    @Autowired
    RefGradesRepository iRefGradeRepository;

    @Override
    public RefGrades addRefGrades(RefGrades grade) {

        iRefGradeRepository.create(grade);
        return grade;
    }

    @Override
    public RefGrades updateRefGrades(RefGrades grade) {

        iRefGradeRepository.update(grade);
        return grade;
    }

    @Override
    public RefGrades getRefGradesById(String id) {

        return iRefGradeRepository.findOne(id);
    }

    @Override
    public void deleteRefGrades(String gradeId) {

        iRefGradeRepository.delete(gradeId);

    }

    @Override
    public List<RefGrades> getAllRefGrades() {

        return iRefGradeRepository.findAll();
    }

}
