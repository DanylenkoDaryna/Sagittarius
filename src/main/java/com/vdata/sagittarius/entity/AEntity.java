package com.vdata.sagittarius.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public abstract class AEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
