package com.csquare.ums.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ums.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
