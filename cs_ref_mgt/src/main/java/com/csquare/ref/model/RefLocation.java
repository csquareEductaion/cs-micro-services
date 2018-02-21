package com.csquare.ref.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.csquare.framework.entity.PKGenerator;


@Entity
@Table(name = "ref_location", schema = "ref_mgt")
@NamedQuery(name = "getAllRefLocation", query = NamedQueryConstants.getAllRefLocation)
public class RefLocation {

    @Id
    @Column(name = "pk")
    @GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    private String pk;

    @Column(name = "location_name")
    private String location_name;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    public String getPk() {

        return pk;
    }

    public void setPk(String pk) {

        this.pk = pk;
    }

    public String getLocation_name() {

        return location_name;
    }

    public void setLocation_name(String location_name) {

        this.location_name = location_name;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getPincode() {

        return pincode;
    }

    public void setPincode(String pincode) {

        this.pincode = pincode;
    }

}
