package com.csquare.tutor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.tutor.model.Tutor;



public interface TutorHigherEduRepository extends JpaRepository<Tutor, String> {

}
