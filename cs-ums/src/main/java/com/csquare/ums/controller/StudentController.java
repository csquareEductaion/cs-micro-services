package com.csquare.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.ums.model.Student;
import com.csquare.ums.service.IStudentService;


@RestController
public class StudentController extends RestExceptionHandler {

    @Autowired
    IStudentService iStudentService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, headers = "Accept=application/json")
    public Student addStudent(@RequestBody Student student) {

        student = iStudentService.addUpdateStudent(student);
        return student;
    }

    @RequestMapping(value = "/getStudentById/{studentid}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Student getStudentById(@PathVariable Long studentid) {

        Student student = iStudentService.getStudentById(studentid);

        return student;

    }

}
