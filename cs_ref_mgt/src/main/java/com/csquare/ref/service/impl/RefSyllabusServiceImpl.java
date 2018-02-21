package com.csquare.ref.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ref.dao.RefSyllabusRepository;
import com.csquare.ref.model.RefSyllabus;
import com.csquare.ref.service.IRefSyllabusService;


@Service
public class RefSyllabusServiceImpl implements IRefSyllabusService {

    @Autowired
    RefSyllabusRepository iRefLocationRepository;

    @Override
    public RefSyllabus addRefSyllabus(RefSyllabus refsyllabus) {

        // TODO Auto-generated method stub
        iRefLocationRepository.create(refsyllabus);
        return refsyllabus;
    }

    @Override
    public RefSyllabus updateRefSyllabus(RefSyllabus refsyllabus) {

        iRefLocationRepository.update(refsyllabus);
        return refsyllabus;
    }

    @Override
    public RefSyllabus getRefSyllabusById(String id) {

        // TODO Auto-generated method stub
        return iRefLocationRepository.findOne(id);
    }

    @Override
    public void deleteRefSyllabus(String refsubId) {

        iRefLocationRepository.delete(refsubId);

    }

    @Override
    public List<RefSyllabus> getAllRefSyllabus() {

        // TODO Auto-generated method stub
        return iRefLocationRepository.findAll();
    }

}
