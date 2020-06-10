package com.travelBuddy.backend.travelBuddy.dao;

import com.travelBuddy.backend.travelBuddy.entity.Geolocation;

public interface GeolocationDao {
    
    Geolocation findGeolocationByLonAndLat(float lon, float lat);
}