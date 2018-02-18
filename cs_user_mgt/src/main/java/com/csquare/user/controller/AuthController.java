package com.csquare.user.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csquare.framework.exception.handler.RestExceptionHandler;
import com.csquare.user.model.User;
import com.csquare.user.model.UserSession;
import com.csquare.user.service.IUserRoleService;
import com.csquare.user.service.IUserService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController extends RestExceptionHandler {

    @Autowired
    IUserService iuserService;

    @Autowired
    IUserRoleService iuserRoleService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
    public UserSession login(@RequestBody User user) {

        User userFromDB = iuserService.getUserByEmail(user.getEmail());
        if (null == userFromDB) {

        }
        // get role for user
        UserSession session = new UserSession();
        if (user.getPassword().equals(userFromDB.getPassword())) {
            userFromDB.setPassword(null);
            session.setUser(userFromDB);
            session.setUserRole(iuserRoleService.getUserRoleById(userFromDB.getUser_role()));
            session.setUserId(userFromDB.getEmail());
            session.setSessionId(UUID.randomUUID().toString());
        } else {
            session.setSessionId(null);
        }

        // MailMessage message = new MailMessage();
        // message.setToAddress(user.getEmail());
        // message.setSubject("Subject11111111");
        // message.setBody("lead is created");
        // RestServiceClient.INSTANCE.postForObject("http://localhost:8084/cs_communication_mgt/sendEmail", message, String.class);
        return session;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST, headers = "Accept=application/json")
    public void logout(@RequestHeader String sessionId, @RequestHeader String userId) {

        return;
    }

}
