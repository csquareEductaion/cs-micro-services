package com.csquare.ums.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.ums.entity.Student;
import com.csquare.ums.repository.StudentRepository;
import com.csquare.ums.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	
	
	
	@Autowired
	StudentRepository iStudentRepository;

	@Override
	public Student addUpdateStudent(Student student) {
		// TODO Auto-generated method stub
		iStudentRepository.save(student);
		return student;
	}

	@Override
	public Student getStudentById(Long studentid) {
		// TODO Auto-generated method stub
		return iStudentRepository.findOne(studentid);
	}

}
