package com.travelBuddy.backend.travelBuddy.dao;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.Geolocation;

public interface GeolocationDao {
    
    List<Geolocation> findAllGeolocation();
}