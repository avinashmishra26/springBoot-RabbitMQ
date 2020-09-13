package com.avinash.spring.integration.rabbit.model;

import groovy.transform.EqualsAndHashCode;

/**
 * Created by avinash on 14/09/20.
 */
@EqualsAndHashCode
public class Department {

    private Long depart_id;
    private String name;


    public Long getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(Long depart_id) {
        this.depart_id = depart_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Department{" +
                "Depart_id=" + depart_id +
                ", name='" + name + '\'' +
                '}';
    }
}
