package com.csquare.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.ums.entity.Student;
import com.csquare.ums.service.ProjectService;


/**
 * Custom class for ProjectController
 *
 * @copyright Copyright (c) CodeX. All Right Reserved.
 * @author CodeX
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ProjectController {

	
	@Autowired
	ProjectService projectService;
    /**
     * getCustomerPulseByProjectId - the method
     *
     * @param internalId
     *            - the Integer
     * @return projectService - internalId
     */
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET, headers = "Accept=application/json")
    public Student sayHello() {

        return projectService.sayHello();
    }

}