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

import com.csquare.ums.entity.Tutor;
import com.csquare.ums.service.ITutorService;

@RestController

public class TutorController {

	@Autowired

	ITutorService iTutorService;

	@RequestMapping(value = "/addTutor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addTutor(@RequestBody Tutor tutor) {
		ResponseEntity<?> responseEntity = null;
		Tutor Tutor = null;

		Tutor = iTutorService.addUpdateTutor(tutor);
		responseEntity = new ResponseEntity<Tutor>(Tutor, HttpStatus.OK);

		return responseEntity;
	}

	@RequestMapping(value = "/getTutorById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTutorById(@PathVariable Long tutorid) {
		ResponseEntity<?> responseEntity = null;
		Tutor Tutor = null;
		
			Tutor = iTutorService.getTutorById(tutorid);
			responseEntity = new ResponseEntity<Tutor>(Tutor, HttpStatus.OK);
		
			
		
		return responseEntity;
	
	}	

}
