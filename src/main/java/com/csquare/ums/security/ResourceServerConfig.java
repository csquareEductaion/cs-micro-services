package com.csquare.ums.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.csquare.ums.config.SpringUsernamePasswordAuthenticationFilter;


@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Autowired
	private AuthenticationManager auth;

	@Bean
	SpringUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter() {
		SpringUsernamePasswordAuthenticationFilter filter = new SpringUsernamePasswordAuthenticationFilter();
		
     filter.setAuthenticationManager(auth);
		return filter;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
	    .antMatchers("/oauth/**").permitAll()
	    .antMatchers("/*").authenticated();
	  
	}

}
