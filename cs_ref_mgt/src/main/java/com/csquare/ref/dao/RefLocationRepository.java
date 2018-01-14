package com.csquare.ref.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ref.model.RefGrades;
import com.csquare.ref.model.RefLocation;


public interface RefLocationRepository extends JpaRepository<RefLocation, String> {

}
