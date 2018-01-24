package com.csquare.student.dao;

import org.springframework.stereotype.Repository;

import com.csquare.student.model.Student;
import com.csquare.framework.entity.BaseJpaRepository;


@Repository
public class StudentRepository extends BaseJpaRepository<Student, String> {

}
