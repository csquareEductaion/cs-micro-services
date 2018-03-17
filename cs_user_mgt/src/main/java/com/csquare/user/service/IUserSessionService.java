package com.csquare.user.service;

import java.util.List;

import com.csquare.user.model.UserSession;
import com.csquare.framework.search.SearchCriteria;
import com.csquare.user.model.User;

public interface IUserSessionService {
	
	 	public UserSession login(User User);

	    public String logout(String sessionId);

	    public List<UserSession> searchUserSession(List<SearchCriteria> criterias, int offset, int limit, boolean allMatch);
	    
	    public UserSession getUserBySessionId(String id);

}
