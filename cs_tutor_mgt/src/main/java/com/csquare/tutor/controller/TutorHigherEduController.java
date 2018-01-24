package com.csquare.tutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.tutor.model.TutorHigherEdu;
import com.csquare.tutor.service.ITutorHigherEduService;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
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
    public List<TutorHigherEdu> getAllTutorsEdu() {
    	    	
        return iTutorService.getAllTutorsEdu();
    }
    
    @RequestMapping(value = "/getAllTutorsEdu/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<TutorHigherEdu> getAllTutorsEdu(@PathVariable Integer offset, @PathVariable Integer limit) {

        return iTutorService.getAllTutorsEdu(offset, limit);
    }
}
