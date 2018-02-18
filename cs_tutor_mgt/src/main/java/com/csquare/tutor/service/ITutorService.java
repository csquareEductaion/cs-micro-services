package com.csquare.tutor.service;

import java.util.List;

import com.csquare.tutor.model.Tutor;


public interface ITutorService {

    public Tutor addTutor(Tutor lead);

    public Tutor updateTutor(Tutor lead);

    public void deleteTutor(String leadId);

    public Tutor getTutorById(String id);

    public List<Tutor> getAllTutors(int offset, int limit);

}
