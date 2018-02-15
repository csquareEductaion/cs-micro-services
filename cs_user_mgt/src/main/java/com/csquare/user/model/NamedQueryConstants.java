package com.csquare.user.model;

public interface NamedQueryConstants {

	String getAllUsers = "SELECT user FROM USER user";
	// String getUserByEmail = "SELECT user FROM USER user where user.email=:email";
	
	String getAllUserRoles = "SELECT userRole FROM UserRole userRole";
	
	String getAllUserStatus = "SELECT userStatus FROM UserStatus";
}
