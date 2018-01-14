package com.csquare.ref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.ref.model.RefGrades;
import com.csquare.ref.service.IRefGradesService;


@RestController
public class RefGradessController extends RestExceptionHandler {

    @Autowired
    IRefGradesService iRefGradesService;

    @RequestMapping(value = "/addRefGrades", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefGrades addRefGrades(@RequestBody RefGrades RefGrades) {

    	RefGrades = iRefGradesService.addRefGrades(RefGrades);
        return RefGrades;
    }

    @RequestMapping(value = "/updateRefGrades", method = RequestMethod.POST, headers = "Accept=application/json")
    public RefGrades updateRefGrades(@RequestBody RefGrades student) {

        student = iRefGradesService.updateRefGrades(student);
        return student;
    }
    
    @RequestMapping(value = "/deleteRefGrades", method = RequestMethod.POST, headers = "Accept=application/json")
    public void delteRefGrades(@RequestBody String RefGradesId) {

    	iRefGradesService.deleteRefGrades(RefGradesId);
    }
    
    @RequestMapping(value = "/getRefGradesById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public RefGrades getRefGradesById(@PathVariable String id) {

    	RefGrades grade = iRefGradesService.getRefGradesById(id);
        return grade;
    }

}
