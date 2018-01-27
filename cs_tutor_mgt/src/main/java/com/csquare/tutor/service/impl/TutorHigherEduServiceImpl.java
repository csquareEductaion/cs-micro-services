package com.csquare.tutor.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.tutor.dao.TutorHigherEduRepository;
import com.csquare.tutor.model.TutorHigherEdu;
import com.csquare.tutor.service.ITutorHigherEduService;


@Service
public class TutorHigherEduServiceImpl implements ITutorHigherEduService {

    @Autowired
    TutorHigherEduRepository itutorRepository;

    @Override
    public TutorHigherEdu addTutorEdu(TutorHigherEdu tutor) {

        String pk = UUID.randomUUID().toString();
        tutor.setPk(pk);
        // TODO Auto-generated method stub
        itutorRepository.save(tutor);
        return tutor;
    }

    @Override
    public TutorHigherEdu updateTutorEdu(TutorHigherEdu tutor) {

        itutorRepository.save(tutor);
        return tutor;
    }

    @Override
    public void deleteTutorEdu(String tutorId) {

        itutorRepository.delete(tutorId);
        ;
    }

    @Override
    public TutorHigherEdu getTutorEduById(String id) {

        return itutorRepository.findOne(id);
    }

    @Override
    public List<TutorHigherEdu> getAllTutorsEdu() {

        return itutorRepository.findAll();
    }

    @Override
    public List<TutorHigherEdu> getAllTutorsEdu(int offset, int limit) {

        // TODO Auto-generated method stub
        return itutorRepository.findAll(offset, limit);
    }

}
