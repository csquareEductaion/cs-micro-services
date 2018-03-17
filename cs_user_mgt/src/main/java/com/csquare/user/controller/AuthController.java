package com.csquare.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.user.model.UserSession;
import com.csquare.user.model.User;
import com.csquare.user.service.IUserSessionService;
import com.csquare.framework.search.SearchCriteria;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController extends RestExceptionHandler {

    @Autowired
    IUserSessionService iuserSessionService;
    


    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
    public UserSession login(@RequestBody User user) {

    	SearchCriteria sc = new SearchCriteria();
        sc.setFieldName("userEmail");
        sc.setFieldValue(user.getEmail());
        List<SearchCriteria> scList = new ArrayList<SearchCriteria>();
        scList.add(sc);
        List<UserSession> userFromDBList = iuserSessionService.searchUserSession(scList, -1, -1, true);
        UserSession userFromDB = new UserSession();
        if(userFromDBList.isEmpty()) {
        	
        } else {
        	  userFromDB = userFromDBList.get(0);
        }
        
        UserSession session = new UserSession();
       if(userFromDB.getUserEmail() != null) {
    	   if (userFromDB.getUserEmail().equals(user.getEmail())) { 
           	return userFromDB;
           } else {
           	 session = iuserSessionService.login(user);
           }   
       } else {
    	     session = iuserSessionService.login(user);
       }
    	
    	
        return session;
    }

    @RequestMapping(value = "/logout/{sessionId}", method = RequestMethod.POST, headers = "Accept=application/json")
    public String logout(@PathVariable String sessionId) {
    	String message;
    	if(sessionId != null) {
    		 message = iuserSessionService.logout(sessionId);
    	} else {
    		message = "User Not Found";
    	}
        return message;
    }
    
    @RequestMapping(value = "/searchUserSession/{offset}/{limit}/{allMatch}", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<UserSession> searchUserSession(@RequestBody List<SearchCriteria> criterias, @PathVariable Integer offset, @PathVariable Integer limit,
        @PathVariable Boolean allMatch) {

    	List<UserSession> user = iuserSessionService.searchUserSession(criterias, offset, limit, allMatch);
        return user;
    }
    
    @RequestMapping(value = "/getUserBySessionId/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public UserSession getUserBySessionId(@PathVariable String id) {

        UserSession user = iuserSessionService.getUserBySessionId(id);
        return user;
    }

}
