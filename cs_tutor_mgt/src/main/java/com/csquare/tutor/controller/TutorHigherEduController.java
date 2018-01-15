package com.csquare.tutor.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.tutor.validation.CSquareInputDataValidator;
import com.csquare.tutor.dao.TutorHigherEduRepository;
import com.csquare.tutor.model.Tutor;
import com.csquare.tutor.model.TutorHigherEdu;
import com.csquare.tutor.service.ITutorHigherEduService;
import com.csquare.tutor.service.ITutorService;



@RestController
public class TutorHigherEduController extends RestExceptionHandler {

    @Autowired
    ITutorHigherEduService iTutorService;

    @RequestMapping(value = "/addTutorEdu", method = RequestMethod.POST, headers = "Accept=application/json")
    public TutorHigherEdu addTutorEdu(@RequestBody TutorHigherEdu tutor) {
    	
    	tutor = iTutorService.addTutorEdu(tutor);
        
    	return tutor;
    }

    @RequestMapping(value = "/updateTutorEdu", method = RequestMethod.POST, headers = "Accept=application/json")
    public TutorHigherEdu updateTutorEdu(@RequestBody TutorHigherEdu tutor) {
    	
    	tutor = iTutorService.updateTutorEdu(tutor);
        return tutor;
    }
    
    @RequestMapping(value = "/deleteTutorEdu", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteTutorEdu(@RequestBody String tutorId) {
    	
    	if(tutorId !=null)
    		iTutorService.deleteTutorEdu(tutorId);
    }
    
    @RequestMapping(value = "/getTutorEduById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public TutorHigherEdu getTutorEduById(@PathVariable String id) {
    	
    	TutorHigherEdu tutor = null;
    	if(id !=null)
    		tutor = iTutorService.getTutorEduById(id);
        return tutor;
    }
    
    @RequestMapping(value = "/getAllTutorsEdu", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<TutorHigherEdu> getAllTutorsEdu() {
    	    	
    	ArrayList<TutorHigherEdu> Tutors = iTutorService.getAllTutorsEdu();
        return Tutors;
    }
    
  /*  @RequestMapping(value = "/getAllTutors/{startpoint}/pagesize/{pagesize}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<Tutor> getAllTutors(@PathVariable(value = "startpoint") String startpoint, @PathVariable(value = "pagesize") String pagesize) {
    	
    	//Pageable pageable = new PageRequest(Integer.valueOf(startpoint), Integer.valueOf(pagesize));
    	Pageable pageable = new PageRequest(0, 2);
    	
    	System.out.println("Integer.valueOf(startpoint)--" + Integer.valueOf(startpoint));
    	System.out.println("Integer.valueOf(pagesize)--" + Integer.valueOf(pagesize));
    	ArrayList<Tutor> Tutors = iTutorService.getAllTutors(pageable);
        return leads;
    }*/

}
