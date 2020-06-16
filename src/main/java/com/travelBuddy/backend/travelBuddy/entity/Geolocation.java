package com.travelBuddy.backend.travelBuddy.entity;

public class Geolocation {
    
    private String longitude, latitude;
    private String streetNumber;
    private String postcode;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String lon) {
        longitude = lon;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String lat) {
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