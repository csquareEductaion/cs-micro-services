package com.csquare.ums.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SpringUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
		
		@Override
		protected String obtainUsername(HttpServletRequest request) {
			
			String userName = request.getParameter(getUsernameParameter());
			StringBuilder userBldr = new StringBuilder();
			userBldr.append(userName);
			
			return userBldr.toString();
		}
		
		


}
