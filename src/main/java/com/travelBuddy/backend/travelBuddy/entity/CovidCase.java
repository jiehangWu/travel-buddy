package com.travelBuddy.backend.travelBuddy.entity;

public class CovidCase {
    private String id;
    private float longitude;
    private float latitude;
    private String caseType;

    // getters
    public String getId() {
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

    // setters
    public void setId(String id) {
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
}