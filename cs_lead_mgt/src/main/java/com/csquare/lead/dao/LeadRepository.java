package com.csquare.lead.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.lead.model.Lead;



public interface LeadRepository extends JpaRepository<Lead, String> {

}
