package com.csquare.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.user.model.UserStatus;
import com.csquare.user.service.IUserStatusService;
 
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserStatusController extends RestExceptionHandler {

    @Autowired
    IUserStatusService iuserStatusService;

    @RequestMapping(value = "/addUserStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public UserStatus addUserStatus(@RequestBody UserStatus userStatus) {

        userStatus = iuserStatusService.addUserStatus(userStatus);
        return userStatus;
    }

    @RequestMapping(value = "/updateUserStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public UserStatus updateUserStatus(@RequestBody UserStatus userStatus) {

        userStatus = iuserStatusService.updateUserStatus(userStatus);
        return userStatus;
    }
    
    @RequestMapping(value = "/deleteUserStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public void updateUserStatus(@RequestBody String userStatusId) {

    	iuserStatusService.deleteUserStatus(userStatusId);
    }
    
    @RequestMapping(value = "/getUserStatusById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public UserStatus getUserStatusById(@PathVariable String id) {

    	UserStatus userStatus = iuserStatusService.getUserStatusById(id);
        return userStatus;
    }
    
    @RequestMapping(value = "/getAllUserStatus", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<UserStatus> getAllUserStatus() {
    	    	
        return iuserStatusService.getAllUserStatus();
    }
    
    @RequestMapping(value = "/getAllUserStatus/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<UserStatus> getAllUserStatus(@PathVariable Integer offset, @PathVariable Integer limit) {

        return iuserStatusService.getAllUserStatus(offset, limit);
    }

}
