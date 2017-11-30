package com.csquare.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ums.entity.Student;

public interface StudentRepository extends  JpaRepository<Student, Long> {

}
