package com.csquare.tutor.service;

import java.util.List;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.tutor.model.Tutor;


public interface ITutorService {

    public Tutor addTutor(Tutor lead);

    public Tutor updateTutor(Tutor lead);

    public void deleteTutor(String leadId);

    public Tutor getTutorById(String id);

    public List<Tutor> getAllTutors(int offset, int limit);
    
    public List<Tutor> searchTutor(List<SearchCriteria> criterias, int offset, int limit, boolean allMatch);

}
