package com.csquare.ums.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ums.model.Lead;


public interface LeadRepository extends JpaRepository<Lead, Long> {

}
