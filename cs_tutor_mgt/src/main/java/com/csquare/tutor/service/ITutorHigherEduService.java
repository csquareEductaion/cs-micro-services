package com.csquare.tutor.service;

import java.util.List;
import com.csquare.tutor.model.TutorHigherEdu;


public interface ITutorHigherEduService {

    public TutorHigherEdu addTutorEdu(TutorHigherEdu tutoredu);

    public TutorHigherEdu updateTutorEdu(TutorHigherEdu tutoredu);
    
    public void deleteTutorEdu(String tutoredu);
    
    public TutorHigherEdu getTutorEduById(String tutoreduid);
    
    public List<TutorHigherEdu> getAllTutorsEdu();
    
    public List<TutorHigherEdu> getAllTutorsEdu(int offset, int limit);

}
