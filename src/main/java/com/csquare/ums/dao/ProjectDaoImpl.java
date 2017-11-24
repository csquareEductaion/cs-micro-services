package com.csquare.ums.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.csquare.ums.entity.Student;


@Repository
public class ProjectDaoImpl implements ProjectDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		Student student=em.find(Student.class, id);
		
		return student;
	}

}
