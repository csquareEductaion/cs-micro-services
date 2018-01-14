package com.csquare.ref.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ref.model.RefGrades;
import com.csquare.ref.model.RefLocation;
import com.csquare.ref.model.RefSubject;


public interface RefSubjectRepository extends JpaRepository<RefSubject, String> {

}
