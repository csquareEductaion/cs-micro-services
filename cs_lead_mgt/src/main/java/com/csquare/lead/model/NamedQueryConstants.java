package com.csquare.lead.model;

public interface NamedQueryConstants {

    String getAllLead =
        "SELECT lead FROM Lead lead " + "LEFT OUTER JOIN FETCH lead.leadGradeList lg  " + " LEFT OUTER JOIN FETCH  lead.leadLocationList ll "
            + "LEFT OUTER JOIN FETCH  lead.leadSubjectList lsu " + "LEFT OUTER JOIN FETCH  lead.leadSyllabusList lsy";

    String getAllLeadStatus = "SELECT leadStatus FROM RefLeadStatus leadStatus";

    String getLeadByEmail = "select * from lead_mgt.lead where lead.email =:email";

    String searchLead =
        "SELECT lead FROM Lead lead " + "LEFT OUTER JOIN FETCH lead.leadGradeList lg  " + " LEFT OUTER JOIN FETCH  lead.leadLocationList ll "
            + "LEFT OUTER JOIN FETCH  lead.leadSubjectList lsu " + "LEFT OUTER JOIN FETCH  lead.leadSyllabusList lsy";

}
