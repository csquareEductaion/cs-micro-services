package com.csquare.tutor.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.framework.validation.CSquareInputDataValidator;
import com.csquare.tutor.model.Tutor;
import com.csquare.tutor.service.ITutorService;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TutorController extends RestExceptionHandler {

    @Autowired
    ITutorService iTutorService;

    @RequestMapping(value = "/addTutor", method = RequestMethod.POST, headers = "Accept=application/json")
    public Tutor addTutor(@RequestBody Tutor tutor) throws ValidationException {
    	
    	if(tutor !=null 
    			&& CSquareInputDataValidator.validatePhoneNumber(String.valueOf(tutor.getPhone()))
    			&& CSquareInputDataValidator.isValidEmailAddress(tutor.getEmail())){
    		tutor = iTutorService.addTutor(tutor);
            
    	}
        
    	return tutor;
    }

    @RequestMapping(value = "/updateTutor", method = RequestMethod.POST, headers = "Accept=application/json")
    public Tutor updateTutor(@RequestBody Tutor tutor) throws ValidationException {
    	
    	if(tutor !=null 
    			&& CSquareInputDataValidator.validatePhoneNumber(String.valueOf(tutor.getPhone()))
    			&& CSquareInputDataValidator.isValidEmailAddress(tutor.getEmail())){
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
    public List<Tutor> getAllTutors() {
    	    	
        return iTutorService.getAllTutors();
    }
    
    @RequestMapping(value = "/getAllTutors/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Tutor> getAllTutors(@PathVariable Integer offset, @PathVariable Integer limit) {

        return iTutorService.getAllLeads(offset, limit);
    }
}
