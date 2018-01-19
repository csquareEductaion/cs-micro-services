package com.csquare.lead.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.csquare.lead.model.Lead;



public interface LeadRepository extends JpaRepository<Lead, String> {
	
	// @Query("SELECT lead FROM Lead p ")
	// public List<Lead> getAll(int offset, int size);

}
