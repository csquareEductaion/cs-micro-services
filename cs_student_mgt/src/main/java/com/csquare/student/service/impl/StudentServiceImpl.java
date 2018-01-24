package com.csquare.student.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.student.dao.StudentRepository;
import com.csquare.student.model.Student;
import com.csquare.student.service.IStudentService;




@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentRepository istudentRepository;

    @Override
    public Student addStudent(Student student) {

    	String pk=UUID.randomUUID().toString();
    	student.setpK(pk);
        // TODO Auto-generated method stub
        istudentRepository.save(student); 
        return student;
    }
    
    @Override
    public Student updateStudent(Student student) {
	
        istudentRepository.save(student);
        return student;
    }
    
    @Override
    public void deleteStudent(String studentId) {
	
        istudentRepository.delete(studentId);;
    }

    @Override
    public Student getStudentById(String id) {

        // TODO Auto-generated method stub
        return istudentRepository.findOne(id);
    }

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return istudentRepository.findAll("getAllStudents");
	}

	@Override
	public List<Student> getAllStudents(int offset, int limit) {
		// TODO Auto-generated method stub
		return istudentRepository.findAll("getAllStudents",offset,limit);
	}

}
