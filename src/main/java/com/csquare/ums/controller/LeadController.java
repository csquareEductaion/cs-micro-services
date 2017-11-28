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

import com.csquare.ums.entity.Lead;
import com.csquare.ums.service.ILeadService;

@RestController

public class LeadController {

	@Autowired

	ILeadService iLeadService;

	@RequestMapping(value = "/addLead", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addLead(@RequestBody Lead lead) {
		ResponseEntity<?> responseEntity = null;
		Lead Lead = null;

		Lead = iLeadService.addUpdateLead(lead);
		responseEntity = new ResponseEntity<Lead>(Lead, HttpStatus.OK);

		return responseEntity;
	}

	@RequestMapping(value = "/getLeadById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getLeadById(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Lead Lead = null;
		
			Lead = iLeadService.getLeadById(id);
			responseEntity = new ResponseEntity<Lead>(Lead, HttpStatus.OK);
		
			
		
		return responseEntity;
	
	}	

}
