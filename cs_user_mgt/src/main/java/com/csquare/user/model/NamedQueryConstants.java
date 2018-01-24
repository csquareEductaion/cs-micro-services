package com.csquare.user.model;

public interface NamedQueryConstants {

	String getAllUsers = "SELECT user FROM USER user";
	
	String getAllUserRoles = "SELECT userRole FROM UserRole userRole";
	
	String getAllUserStatus = "SELECT userStatus FROM UserStatus";
}
