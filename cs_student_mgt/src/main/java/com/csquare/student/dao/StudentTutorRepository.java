package com.csquare.student.dao;

import org.springframework.stereotype.Repository;

import com.csquare.student.model.StudentTutor;
import com.csquare.framework.entity.BaseJpaRepository;


@Repository
public class StudentTutorRepository extends BaseJpaRepository<StudentTutor, String> {

}
