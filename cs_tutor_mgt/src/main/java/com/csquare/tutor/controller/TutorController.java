package com.csquare.tutor.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.tutor.validation.CSquareInputDataValidator;
import com.csquare.tutor.model.Tutor;
import com.csquare.tutor.service.ITutorService;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TutorController extends RestExceptionHandler {

    @Autowired
    ITutorService iTutorService;

    @RequestMapping(value = "/addTutor", method = RequestMethod.POST, headers = "Accept=application/json")
    public Tutor addTutor(@RequestBody Tutor tutor) {
    	
    	if(tutor !=null 
    			&& CSquareInputDataValidator.validatePhoneNumber(String.valueOf(tutor.getPhone()))
    			&& CSquareInputDataValidator.isValidEmailAddress(tutor.getEmail())
    			&& tutor.getFirstName() !=null 
    			&& tutor.getCity() !=null ){
    		tutor = iTutorService.addTutor(tutor);
            
    	}
        
    	return tutor;
    }

    @RequestMapping(value = "/updateTutor", method = RequestMethod.POST, headers = "Accept=application/json")
    public Tutor updateTutor(@RequestBody Tutor tutor) {
    	
    	if(tutor !=null 
    			&& CSquareInputDataValidator.validatePhoneNumber(String.valueOf(tutor.getPhone()))
    			&& CSquareInputDataValidator.isValidEmailAddress(tutor.getEmail())
    			&& tutor.getFirstName() !=null 
    			&& tutor.getCity() !=null ){
    		tutor = iTutorService.updateTutor(tutor);
            
    	}
        return tutor;
    }
    
    @RequestMapping(value = "/deleteTutor", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteTutor(@RequestBody String tutorId) {
    	
    	if(tutorId !=null)
    		iTutorService.deleteTutor(tutorId);
    }
    
    @RequestMapping(value = "/getTutorById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Tutor getTutorById(@PathVariable String id) {
    	
    	Tutor tutor = null;
    	if(id !=null)
    		tutor = iTutorService.getTutorById(id);
        return tutor;
    }
    
    @RequestMapping(value = "/getAllTutors", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<Tutor> getAllTutors() {
    	    	
    	ArrayList<Tutor> Tutors = iTutorService.getAllTutors();
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
