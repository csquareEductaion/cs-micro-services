package com.csquare.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.user.model.UserRole;
import com.csquare.user.service.IUserRoleService;
 
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRoleController extends RestExceptionHandler {

    @Autowired
    IUserRoleService iuserRoleService;

    @RequestMapping(value = "/addUserRole", method = RequestMethod.POST, headers = "Accept=application/json")
    public UserRole addUserRole(@RequestBody UserRole userRole) {

        userRole = iuserRoleService.addUserRole(userRole);
        return userRole;
    }

    @RequestMapping(value = "/updateUserRole", method = RequestMethod.POST, headers = "Accept=application/json")
    public UserRole updateUserRole(@RequestBody UserRole userRole) {

        userRole = iuserRoleService.updateUserRole(userRole);
        return userRole;
    }
    
    @RequestMapping(value = "/deleteUserRole", method = RequestMethod.POST, headers = "Accept=application/json")
    public void updateUserRole(@RequestBody String userRoleId) {

    	iuserRoleService.deleteUserRole(userRoleId);
    }
    
    @RequestMapping(value = "/getUserRoleById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public UserRole getUserRoleById(@PathVariable String id) {

    	UserRole userRole = iuserRoleService.getUserRoleById(id);
        return userRole;
    }

}
