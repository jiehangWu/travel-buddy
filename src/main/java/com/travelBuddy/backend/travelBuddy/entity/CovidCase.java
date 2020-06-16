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
    private Long id;
    private String longitude;
    private String latitude;
    private String caseType;
    private int count;

    // getters
    public Long getId() {
        return id;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getCaseType() {
        return caseType;
    }

    public int getCount() {
        return count;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public void setCount(int count) {
        this.count = count;
    }
}