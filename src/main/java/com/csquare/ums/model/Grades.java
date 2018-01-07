package com.csquare.ums.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "grades", schema = "public")
public class Grades {

    private long id;
    private String itemName;
    private Tutor tutor;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    @Column(name = "grade")
    public String getItemName() {

        return itemName;
    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    @ManyToOne
    public Tutor getTutor() {

        return tutor;
    }

    public void setTutor(Tutor tutor) {

        this.tutor = tutor;
    }

}
