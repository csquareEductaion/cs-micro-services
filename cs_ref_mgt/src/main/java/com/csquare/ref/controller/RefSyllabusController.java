package com.csquare.ref.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.ref.model.RefSyllabus;
import com.csquare.ref.service.IRefSyllabusService;

@RestController
public class RefSyllabusController extends RestExceptionHandler {

    @Autowired
    IRefSyllabusService irefsubjectService;

    @RequestMapping(value = "/addRefSyllabus", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefSyllabus addRefSyllabus(@RequestBody RefSyllabus refsubject) {

    	refsubject = irefsubjectService.addRefSyllabus(refsubject);
        return refsubject;
    }

    @RequestMapping(value = "/updateRefSyllabus", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefSyllabus updateRefSyllabus(@RequestBody RefSyllabus refsubject) {

    	refsubject = irefsubjectService.updateRefSyllabus(refsubject);
        return refsubject;
    }
    
    @RequestMapping(value = "/deleteRefSyllabus", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteRefSyllabus(@RequestBody String reflocationId) {

    	irefsubjectService.deleteRefSyllabus(reflocationId);
    }
    
    @RequestMapping(value = "/getRefSyllabusById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public RefSyllabus getRefSyllabusById(@PathVariable String id) {

    	RefSyllabus refsubject = irefsubjectService.getRefSyllabusById(id);
        return refsubject;
    }
    
    @RequestMapping(value = "/getAllRefSyllabus", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<RefSyllabus> getAllRefSyllabus() {

    	ArrayList<RefSyllabus> refsubject = irefsubjectService.getAllRefSyllabus();
        return refsubject;
    }

}
