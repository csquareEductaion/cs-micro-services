package com.csquare.lead.dao;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.lead.model.Lead;


@Repository
public class LeadRepository extends BaseJpaRepository<Lead, String> {

}
