package com.csquare.ums.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter {
	private static final Logger logger = Logger.getLogger(CorsFilter.class);
	
	
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
		try {
			HttpServletResponse response = (HttpServletResponse) res;
			HttpServletRequest request = (HttpServletRequest) req;
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT,OPTIONS");
			response.setHeader("Access-Control-Allow-Headers",
					"x-requested-with,X-CSRF-Token,X-XSRF-Token,Content-Type,Accept,Authorization");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Credentials", "true");

			if (!"OPTIONS".equals(request.getMethod())) {
				chain.doFilter(req, res);
			}

		} catch (IOException | ServletException e) {
			logger.error("Exception in CORS filter: " + e.getMessage());
		}

	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}
