package com.csquare.tutor.model;

public interface NamedQueryConstants {

	String getAllTutors = "SELECT tutor FROM Tutor tutor";
	
	String searchTutor=
	        "select DISTINCT tutor from Tutor tutor";
	
}
