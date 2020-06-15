package com.travelBuddy.backend.travelBuddy.service;
import com.travelBuddy.backend.travelBuddy.entity.Geolocation;

import java.util.List;

public interface GeolocationService {
    List<Geolocation> findAllGeolocation();
}