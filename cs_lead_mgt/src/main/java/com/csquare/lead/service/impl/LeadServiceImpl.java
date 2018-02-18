package com.csquare.lead.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csquare.framework.util.StringUtil;
import com.csquare.lead.dao.LeadRepository;
import com.csquare.lead.model.Lead;
import com.csquare.lead.model.NamedQueryConstants;
import com.csquare.lead.model.search.SearchCriteria;
import com.csquare.lead.service.ILeadService;


@Service
public class LeadServiceImpl implements ILeadService {

    @Autowired
    private LeadRepository ileadRepository;

    @Override
    public Lead addLead(Lead lead) {

        // TODO Auto-generated method stub
        lead = ileadRepository.save(lead);
        return lead;
    }

    @Override
    public Lead updateLead(Lead lead) {

        lead = ileadRepository.save(lead);
        return lead;
    }

    @Override
    public void deleteLead(String leadId) {

        ileadRepository.delete(leadId);
    }

    @Override
    public Lead getLeadById(String id) {

        return ileadRepository.findOne(id);
    }

    @Override
    public List<Lead> getAllLeads(int offset, int limit) {

        return ileadRepository.findAll(offset, limit, "leadGradeList", "leadLocationList", "leadSubjectList", "leadSyllabusList");
    }

    @Override
    public List<Lead> searchLead(List<SearchCriteria> searchCriteriaList, int offset, int limit) {

        HashMap<String, String> paramsMap = new HashMap<String, String>();
        StringBuilder queryBuilder = new StringBuilder(NamedQueryConstants.searchLead);
        if (null != searchCriteriaList && !searchCriteriaList.isEmpty()) {
            StringUtil.append(queryBuilder, " where");

            for (SearchCriteria sc : searchCriteriaList) {
                StringUtil.append(queryBuilder, " ");
                StringUtil.append(queryBuilder, "lead.");
                StringUtil.append(queryBuilder, sc.getFieldName());
                StringUtil.append(queryBuilder, "=:");
                StringUtil.append(queryBuilder, sc.getFieldName());
                StringUtil.append(queryBuilder, " ");

                paramsMap.put(sc.getFieldName(), sc.getFieldValue());

                StringUtil.append(queryBuilder, "AND");

            }

            int idxAnd = queryBuilder.lastIndexOf("AND");
            if (idxAnd > 0) {
                queryBuilder.delete(idxAnd, queryBuilder.length());
            }
        }

        List<Lead> leadList = ileadRepository.findByHQL(queryBuilder.toString(), paramsMap, true, offset, limit);
        return leadList;
    }

}
