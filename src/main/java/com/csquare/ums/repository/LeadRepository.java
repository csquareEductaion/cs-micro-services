package com.csquare.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csquare.ums.entity.Lead;

public interface LeadRepository extends  JpaRepository<Lead, Long> {

}
