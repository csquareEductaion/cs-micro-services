package com.csquare.lead.dao;

import org.springframework.stereotype.Repository;

import com.csquare.framework.entity.BaseJpaRepository;
import com.csquare.lead.model.ref.RefLeadStatus;


@Repository
public class LeadStatusRepository extends BaseJpaRepository<RefLeadStatus, String> {

}
