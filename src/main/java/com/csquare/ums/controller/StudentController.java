package com.csquare.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.csquare.ums.entity.Student;
import com.csquare.ums.service.IStudentService;

@RestController

public class StudentController {

	@Autowired

	IStudentService iStudentService;

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		ResponseEntity<?> responseEntity = null;
		Student Student = null;

		Student = iStudentService.addUpdateStudent(student);
		responseEntity = new ResponseEntity<Student>(Student, HttpStatus.OK);

		return responseEntity;
	}

	@RequestMapping(value = "/getStudentById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getStudentById(@PathVariable Long studentid) {
		ResponseEntity<?> responseEntity = null;
		Student Student = null;
		
			Student = iStudentService.getStudentById(studentid);
			responseEntity = new ResponseEntity<Student>(Student, HttpStatus.OK);
		
			
		
		return responseEntity;
	
	}	

}
