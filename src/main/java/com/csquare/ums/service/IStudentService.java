package com.csquare.ums.service;

import com.csquare.ums.entity.Student;

public interface IStudentService {
	
	
	public Student addUpdateStudent(Student student);
	public Student getStudentById(Long studentid);

}
