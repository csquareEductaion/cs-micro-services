package com.csquare.ums.dto;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.csquare.ums.entity.UserMaster;

public class UserInfo extends User {
	private UserMaster user;

	public UserInfo(String username, String password, UserMaster user, List<GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.user = user;
	}

	public UserMaster getUser() {
		return user;
	}
	
	
	
	

}
