package com.csquare.ref.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.ref.model.RefSubject;
import com.csquare.ref.service.IRefSubjectService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RefSubjectController extends RestExceptionHandler {

    @Autowired
    IRefSubjectService irefsubjectService;

    @RequestMapping(value = "/addRefSubject", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefSubject addRefSubject(@RequestBody RefSubject refsubject) {

    	refsubject = irefsubjectService.addRefSubject(refsubject);
        return refsubject;
    }

    @RequestMapping(value = "/updateRefSubject", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefSubject updateRefSubject(@RequestBody RefSubject refsubject) {

    	refsubject = irefsubjectService.updateRefSubject(refsubject);
        return refsubject;
    }
    
    @RequestMapping(value = "/deleteRefSubject", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteRefSubject(@RequestBody String reflocationId) {

    	irefsubjectService.deleteRefSubject(reflocationId);
    }
    
    @RequestMapping(value = "/getRefSubjectById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public RefSubject getRefSubjectById(@PathVariable String id) {

    	RefSubject refsubject = irefsubjectService.getRefSubjectById(id);
        return refsubject;
    }

    @RequestMapping(value = "/getAllRefSubjects", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<RefSubject> getAllRefSubjects() {

        return irefsubjectService.getAllRefSubjects();
    }

}
