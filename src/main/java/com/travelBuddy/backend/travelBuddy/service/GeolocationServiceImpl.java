package com.travelBuddy.backend.travelBuddy.service;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.dao.GeolocationDao;
import com.travelBuddy.backend.travelBuddy.entity.Geolocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeolocationServiceImpl implements GeolocationService {
    @Autowired
    private GeolocationDao geoLocationDao;

    @Transactional
    @Override
    public List<Geolocation> findAllGeolocation() {
        return geoLocationDao.findAllGeolocation();
    }
    
}