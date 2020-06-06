package com.travelBuddy.backend.travelBuddy.entity;

public class Postcode {
    private String code;
    private String city;
    private String country;

    // getters
    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    // setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
