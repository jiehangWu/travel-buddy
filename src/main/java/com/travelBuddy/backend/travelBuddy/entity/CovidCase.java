package com.travelBuddy.backend.travelBuddy.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CovidCase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private float longitude;
    private float latitude;
    private String caseType;
    private int count;

    // getters
    public UUID getId() {
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
    public void setId(UUID id) {
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