package com.csquare.tutor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.tutor.dao.TutorRepository;
import com.csquare.tutor.model.Tutor;
import com.csquare.tutor.service.ITutorService;


@Service
public class TutorServiceImpl implements ITutorService {

    @Autowired
    TutorRepository itutorRepository;

    @Override
    public Tutor addTutor(Tutor tutor) {

        // TODO Auto-generated method stub
        itutorRepository.save(tutor);
        return tutor;
    }

    @Override
    public Tutor updateTutor(Tutor tutor) {

        itutorRepository.save(tutor);
        return tutor;
    }

    @Override
    public void deleteTutor(String tutorId) {

        itutorRepository.delete(tutorId);
    }

    @Override
    public Tutor getTutorById(String id) {

        return itutorRepository.findOne(id);
    }

    @Override
    public List<Tutor> getAllTutors(int offset, int limit) {

        return itutorRepository.findAll(offset, limit, "tutorGradeList", "tutorLocationList", "tutorSubjectList", "tutorSyllabusList",
            "tutorStudentList");
    }

}
