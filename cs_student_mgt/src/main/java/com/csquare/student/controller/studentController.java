package com.csquare.student.controller;

import java.util.ArrayList;
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
import com.csquare.student.model.StudentTutor;
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

    @RequestMapping(value = "/getAllStudents/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Student> getAllStudents(@PathVariable Integer offset, @PathVariable Integer limit) {

        return istudentService.getAllStudents(offset, limit);
    }
    
    @RequestMapping(value = "/deleteStudentTutor/{studentId}", method = RequestMethod.POST, headers = "Accept=application/json")
    public void deleteStudentTutor(@PathVariable String studentId) {

        istudentService.deleteStudentTutor(studentId);
    }
    
    @RequestMapping(value = "/getStudentByTutorId/{tutorId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Student> getStudentByTutorId(@PathVariable String tutorId) {

    	List<StudentTutor> studentList = new ArrayList<StudentTutor>();
    	studentList = istudentService.getStudentByTutorId(tutorId);
    	int len = studentList.size();
    	List<Student> student = new ArrayList<Student>(); 
    	for(int i = 0; i< len; i++) {
    		StudentTutor stud = studentList.get(i);
    		System.out.println(istudentService.getStudentById(stud.getStudentId()));
    		student.add(i, istudentService.getStudentById(stud.getStudentId()));
    	}
    	
        return student;
    }
    
}
