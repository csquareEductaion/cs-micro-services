package com.csquare.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.search.SearchCriteria;
import com.csquare.student.dao.StudentRepository;
import com.csquare.student.dao.StudentTutorRepository;
import com.csquare.student.model.Student;
import com.csquare.student.model.StudentTutor;
import com.csquare.student.service.IStudentService;


@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentRepository istudentRepository;
    
    @Autowired
    StudentTutorRepository istudentTutorRepository;

    @Override
    public Student addStudent(Student student) {

        // TODO Auto-generated method stub
        istudentRepository.create(student);
        // MailMessage message = new MailMessage();
        // message.setToAddress(student.getEmail());
        // message.setSubject("Subject11111111");
        // message.setBody("djhfjshfihtiertgjerkgnjgnjdfngjdfnjdg");
        //
        // RestServiceClient.INSTANCE.postForObject("http://localhost:8084/cs_communication_mgt/sendEmail", message, String.class);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {

        istudentRepository.update(student);
        return student;
    }

    @Override
    public void deleteStudent(String studentId) {

        istudentRepository.delete(studentId);
        ;
    }

    @Override
    public Student getStudentById(String id) {

        // TODO Auto-generated method stub
        return istudentRepository.findOne(id);
    }

    @Override
    public List<Student> getAllStudents(int offset, int limit) {

        // TODO Auto-generated method stub
        return istudentRepository.findAll(offset, limit, "studentTutorList", "studentSubjectList");
    }
    
    @Override
    public void deleteStudentTutor(String studentId) {

    	istudentTutorRepository.delete(studentId);
        ;
    }

	@Override
	public List<StudentTutor> getStudentByTutorId(String tutorId) {
		// TODO Auto-generated method stub
		SearchCriteria sc = new SearchCriteria();
		sc.setFieldName("tutorId");
		sc.setFieldValue(tutorId);
		
		List<SearchCriteria> scList = new ArrayList<SearchCriteria>();
		scList.add(sc);
		
		return istudentTutorRepository.search(scList,-1,-1,true);
	}

}
