package com.csqaure.ums.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.csquare.ums.dto.UserInfo;
import com.csquare.ums.entity.UserMaster;

public class SpringSecurityAuditorAware implements AuditorAware<UserMaster>  {
	@Override
	public UserMaster getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		System.out.println("Authentication name " + authentication.getName());
		UserInfo userInfo = (UserInfo) authentication.getDetails();
		return userInfo.getUser();
	}
	

}
