package com.travelBuddy.backend.travelBuddy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CovidCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    private float longitude;
    private float latitude;
    private String caseType;
    private int count;

    // getters
    public int getId() {
        return id;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getCaseType() {
        return caseType;
    }

    public int getCount() {
        return count;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public void setCount(int count) {
        this.count = count;
    }
}