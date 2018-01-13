package com.csquare.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.student.model.Student;




public interface StudentRepository extends JpaRepository<Student, String> {

}
