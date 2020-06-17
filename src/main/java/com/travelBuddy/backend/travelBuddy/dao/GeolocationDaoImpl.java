package com.travelBuddy.backend.travelBuddy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.Geolocation;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class GeolocationDaoImpl implements GeolocationDao {
    private NamedParameterJdbcTemplate template;

    public GeolocationDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Geolocation> findAllGeolocation() {
        final String sql = "select latitude, longitude from geolocation";

        return template.query(sql, new BeanPropertyRowMapper(Geolocation.class));
    }

    @Override
    public List<String> findEquipmentsByLocation(double lat, double lon) {
        final String sql = new StringBuilder()
                                .append("select se.type from geolocation g, publicarea p, ")
                                .append("safetyequipment se, provideequipment pe ")
                                .append("where g.latitude = p.latitude and g.longitude = p.longitude ")
                                .append("and p.id = pe.publicareaid and pe.equipmentid = se.id ")
                                .append("and g.latitude=:lat and g.longitude=:lon")
                                .toString();

        SqlParameterSource param = new MapSqlParameterSource()
                                        .addValue("lat", lat)
                                        .addValue("lon", lon);
        
        return template.query(sql, param, new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1).split(" ")[0];
            }
        });
    }
}