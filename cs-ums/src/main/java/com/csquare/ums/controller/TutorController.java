package com.csquare.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.ums.model.Tutor;
import com.csquare.ums.service.ITutorService;


@RestController
public class TutorController extends RestExceptionHandler {

    @Autowired
    ITutorService iTutorService;

    @RequestMapping(value = "/addTutor", method = RequestMethod.POST, headers = "Accept=application/json")
    public Tutor addTutor(@RequestBody Tutor tutor) {

        tutor = iTutorService.addUpdateTutor(tutor);

        return tutor;
    }

    @RequestMapping(value = "/getTutorById/{tutorid}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Tutor getTutorById(@PathVariable Long tutorid) {

        Tutor tutor = iTutorService.getTutorById(tutorid);

        return tutor;

    }

}
