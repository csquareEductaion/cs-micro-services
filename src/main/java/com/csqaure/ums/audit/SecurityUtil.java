package com.csqaure.ums.audit;

import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.csquare.ums.dto.UserInfo;

public class SecurityUtil {
	public static UserInfo getUserInfo() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = null;
		if(Objects.nonNull(auth) && auth.isAuthenticated()) {
			 userInfo = (UserInfo)auth.getPrincipal();	
		}
		
		
		return userInfo;
	}

}
