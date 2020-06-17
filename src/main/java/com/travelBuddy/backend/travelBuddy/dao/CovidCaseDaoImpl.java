package com.travelBuddy.backend.travelBuddy.dao;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.CovidCase;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CovidCaseDaoImpl implements CovidCaseDao {

    private NamedParameterJdbcTemplate template;
    
    public CovidCaseDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<CovidCase> findAndGroupCovidCases() {
        final String sql = new StringBuilder()
                        .append("select latitude, longitude, count(*)")
                        .append(" from covidcase group by (latitude, longitude)")
                        .toString();

        return template.query(sql, new BeanPropertyRowMapper(CovidCase.class));
    }

    @Override
    public List<CovidCase> findCovidCasesByCaseType(String caseType) {
        final String sql = new StringBuilder()
                        .append("select latitude, longitude, count(*)")
                        .append("from covidcase where casetype = ")
                        .append("'" + caseType + "'")
                        .append(" group by (latitude, longitude)")
                        .toString();
        
        return (List<CovidCase>)template.query(sql, new BeanPropertyRowMapper(CovidCase.class));
    }

    @Override
    public List<CovidCase> findCovidCaseByLatAndLon(String lat, String lon) {
        final String sql = new StringBuilder()
                            .append("select id from covidcase ")
                            .append("where longitude = :lon and latitude = :lat ")
                            .toString();
        
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("lon", lon)
                                    .addValue("lat", lat);

        return template.query(sql, param, new BeanPropertyRowMapper(CovidCase.class));
    }

    @Override
    public String findCityOfCovidCaseByLatAndLon(String lat, String lon) {
        final String sql = new StringBuilder()
                            .append("select distinct city from postcode p, ")
                            .append("geolocation g, covidcase c ")
                            .append("where c.longitude = g.longitude ")
                            .append("and c.latitude = g.latitude ")
                            .append("and g.postcode = p.code ")
                            .append("and c.longitude = :lon and ")
                            .append("c.latitude = :lat")
                            .toString();
        
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("lon", lon)
                                    .addValue("lat", lat);

        return (String)template.queryForObject(sql, param, String.class);
    }

    @Override 
    public int findTotalCovidCaseByLatAndLon(String lat, String lon) {
        final String sql = new StringBuilder()
                            .append("select count(*) from covidcase ")
                            .append("where longitude = :lon and latitude = :lat ")
                            .append("group by latitude, longitude")
                            .toString();
        
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("lon", lon)
                                    .addValue("lat", lat);

        return (int)template.queryForObject(sql, param, Integer.class);
    }

}