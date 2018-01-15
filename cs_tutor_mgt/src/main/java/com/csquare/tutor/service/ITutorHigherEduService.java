package com.csquare.tutor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.csquare.tutor.model.Tutor;
import com.csquare.tutor.model.TutorHigherEdu;


public interface ITutorHigherEduService {

    public TutorHigherEdu addTutorEdu(TutorHigherEdu tutoredu);

    public TutorHigherEdu updateTutorEdu(TutorHigherEdu tutoredu);
    
    public void deleteTutorEdu(String tutoredu);
    
    public TutorHigherEdu getTutorEduById(String tutoreduid);
    
    public ArrayList<TutorHigherEdu> getAllTutorsEdu();
    
   // public ArrayList<Lead> getAllLeads(Pageable pageable);

}
