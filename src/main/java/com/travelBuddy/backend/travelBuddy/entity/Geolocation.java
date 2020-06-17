package com.travelBuddy.backend.travelBuddy.entity;

public class Geolocation {
    private String latitude, longitude;
    private String streetNumber;
    private String postcode;

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float lon) {
        longitude = lon;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float lat) {
        latitude = lat;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String sn) {
        streetNumber = sn;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String pc) {
        postcode = pc;
    }

}