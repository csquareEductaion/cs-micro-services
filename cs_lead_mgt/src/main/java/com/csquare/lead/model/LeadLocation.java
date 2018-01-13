package com.csquare.lead.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "lead_location", schema = "lead_mgt")

public class LeadLocation {

    @Id
    @Column(name = "pk")
    private String pk;

    @Column(name = "location_id")
    private String locationId;

    @Column(name = "lead_id")
    private String leadId;

    public String getPk() {

        return pk;
    }

    public void setPk(String pk) {

        this.pk = pk;
    }

    public String getLocationId() {

        return locationId;
    }

    public void setLocationId(String locationId) {

        this.locationId = locationId;
    }

    public String getLeadId() {

        return leadId;
    }

    public void setLeadId(String leadId) {

        this.leadId = leadId;
    }

}
