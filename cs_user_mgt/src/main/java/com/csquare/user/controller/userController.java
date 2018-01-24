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
import com.csquare.user.model.User;
import com.csquare.user.service.IUserService;
 
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class userController extends RestExceptionHandler {

    @Autowired
    IUserService iuserService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
    public User addUser(@RequestBody User user) {

        user = iuserService.addUser(user);
        return user;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, headers = "Accept=application/json")
    public User updateUser(@RequestBody User user) {

        user = iuserService.updateUser(user);
        return user;
    }
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST, headers = "Accept=application/json")
    public void updateUser(@RequestBody String userId) {

        iuserService.deleteUser(userId);
    }
    
    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public User getUserById(@PathVariable String id) {

    	User user = iuserService.getUserById(id);
        return user;
    }
    
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<User> getAllUsers() {
    	    	
        return iuserService.getAllUsers();
    }
    
    @RequestMapping(value = "/getAllUsers/{offset}/{limit}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<User> getAllUsers(@PathVariable Integer offset, @PathVariable Integer limit) {

        return iuserService.getAllUsers(offset, limit);
    }


}
