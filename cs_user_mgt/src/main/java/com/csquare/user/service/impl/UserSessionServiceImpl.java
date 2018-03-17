package com.csquare.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.user.dao.UserSessionRepository;
import com.csquare.user.model.User;
import com.csquare.user.model.UserSession;
import com.csquare.user.service.IUserSessionService;
import com.csquare.user.service.IUserService;


@Service
public class UserSessionServiceImpl implements IUserSessionService {

    @Autowired
    UserSessionRepository iUserSessionRepository;
    
    @Autowired
    IUserService iUserService;
        
	@Override
	public UserSession login(User user) {
		// TODO Auto-generated method stub
		  SearchCriteria sc = new SearchCriteria();
        sc.setFieldName("email");
        sc.setFieldValue(user.getEmail());
        List<SearchCriteria> scList = new ArrayList<SearchCriteria>();
        scList.add(sc);
        List<User> userFromDBList = iUserService.searchUser(scList, -1, -1, true);
        if (null == userFromDBList) {
            return null;
        }

        User userFromDB = userFromDBList.get(0);
        // get role for user
        UserSession session = new UserSession();
        if (user.getPassword().equals(userFromDB.getPassword())) {
            userFromDB.setPassword(null);
//            session.setUser(userFromDB);
            session.setUserRole(userFromDB.getUser_role());
            session.setUserId(userFromDB.getpK());
            session.setUserEmail(userFromDB.getEmail());
            session.setSessionId(UUID.randomUUID().toString());
        } else {
            session.setSessionId(null);
        }
        
        iUserSessionRepository.create(session);
		return session;
	}

	@Override
	public String logout(String sessionId) {
		// TODO Auto-generated method stub
		iUserSessionRepository.delete(sessionId);
		return "Logged Out Successfully";
	}
	
	@Override
    public List<UserSession> searchUserSession(List<SearchCriteria> criterias, int offset, int limit, boolean allMatch) {

        List<UserSession> userList = iUserSessionRepository.search(criterias, offset, limit, allMatch);
        return userList;
    }

	@Override
	public UserSession getUserBySessionId(String id) {
		// TODO Auto-generated method stub
		return iUserSessionRepository.findOne(id);
	}


}
