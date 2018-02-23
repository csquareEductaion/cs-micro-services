package com.csquare.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.student.model.Student;
import com.csquare.student.service.IStudentService;

 
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class studentController extends RestExceptionHandler {

    @Autowired
    IStudentService istudentService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, headers = "Accept=application/json")
    public Student addStudent(@RequestBody Student student) {

        student = istudentService.addStudent(student);
        return student;
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST, headers = "Accept=application/json")
    public Student updateStudent(@RequestBody Student student) {

        student = istudentService.updateStudent(student);
        return student;
    }
    
    @RequestMapping(value = "/deleteStudent/{studentId}", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteStudent(@PathVariable String studentId) {

        istudentService.deleteStudent(studentId);
    }
    
    @RequestMapping(value = "/getStudentById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Student getStudentById(@PathVariable String id) {

    	Student student = istudentService.getStudentById(id);
        return student;
    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Student> getAllStudents() {

        return istudentService.getAllStudents();
    }

    @RequestMapping(value = "/getAllStudents/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Student> getAllStudents(@PathVariable Integer offset, @PathVariable Integer limit) {

        return istudentService.getAllStudents(offset, limit);
    }
    
}
