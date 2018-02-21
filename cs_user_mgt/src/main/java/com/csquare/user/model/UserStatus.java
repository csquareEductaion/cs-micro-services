package com.csquare.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.csquare.framework.entity.PKGenerator;


@Entity
@Table(name = "ref_user_status", schema = "user_mgt")

public class UserStatus {

    @Id
    @GeneratedValue(generator = PKGenerator.NAME)
    @GenericGenerator(name = PKGenerator.NAME, strategy = PKGenerator.CLASS)
    @Column(name = "pk")
    private String pk;

    @Column(name = "user_status")
    private String user_status;

    public String getPk() {

        return pk;
    }

    public void setPk(String pk) {

        this.pk = pk;
    }

    public String getUser_status() {

        return user_status;
    }

    public void setUser_status(String user_status) {

        this.user_status = user_status;
    }

}
