package com.travelBuddy.backend.travelBuddy.dao;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.Geolocation;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GeolocationDaoImpl implements GeolocationDao {
    private NamedParameterJdbcTemplate template;

    public GeolocationDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Geolocation> findAllGeolocation() {
        final String sql = "select longitude, latitude from geolocation";

        return template.query(sql, new BeanPropertyRowMapper(Geolocation.class));
    }

    
    
}