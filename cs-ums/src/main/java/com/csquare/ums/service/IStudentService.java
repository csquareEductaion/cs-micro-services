package com.csquare.ums.service;

import com.csquare.ums.model.Student;


public interface IStudentService {

    public Student addUpdateStudent(Student student);

    public Student getStudentById(Long studentid);

}
