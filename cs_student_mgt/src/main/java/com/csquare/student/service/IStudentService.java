package com.csquare.student.service;

import java.util.List;

import com.csquare.student.model.Student;

public interface IStudentService {

    public Student addStudent(Student Student);

    public Student updateStudent(Student Student);
    
    public void deleteStudent(String StudentId);
    
    public Student getStudentById(String id);
    
    public List<Student> getAllStudents();
    
    public List<Student> getAllStudents(int offset, int limit);

}
