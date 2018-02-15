package com.csquare.lead.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csquare.lead.model.Lead;


@Repository
public interface LeadRepository extends JpaRepository<Lead, String> {
	public Lead findByEmail(String email);

}
