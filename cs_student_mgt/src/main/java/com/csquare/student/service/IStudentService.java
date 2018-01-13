package com.csquare.student.service;

import com.csquare.student.model.Student;

public interface IStudentService {

    public Student addStudent(Student Student);

    public Student updateStudent(Student Student);
    
    public void deleteStudent(String StudentId);
    
    public Student getStudentById(String id);

}
