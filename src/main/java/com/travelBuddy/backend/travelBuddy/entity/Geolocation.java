package com.travelBuddy.backend.travelBuddy.entity;

public class Geolocation {
    private double latitude, longitude;
    private String streetNumber;
    private String postcode;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double lon) {
        longitude = lon;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double lat) {
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