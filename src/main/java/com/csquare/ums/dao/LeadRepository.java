package com.csquare.ums.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ums.entity.Lead;

public interface LeadRepository extends  JpaRepository<Lead, Long> {

}
