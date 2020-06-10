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
                        .append("select longitude, latitude, count(*)")
                        .append(" from covidcase group by (longitude, latitude)")
                        .toString();

        return template.query(sql, new BeanPropertyRowMapper(CovidCase.class));
    }

    @Override
    public List<CovidCase> findCovidCasesByCaseType(String caseType) {
        final String sql = new StringBuilder()
                        .append("select longitude, latitude, count(*)")
                        .append("from covidcase where casetype = ")
                        .append("'" + caseType + "'")
                        .append(" group by (longitude, latitude)")
                        .toString();
        
        return template.query(sql, new BeanPropertyRowMapper(CovidCase.class));
    }

    @Override
    public CovidCase findCovidCaseByLonAndLat(float lon, float lat) {
        final String sql = new StringBuilder()
                            .append("select count(*) from covidcase ")
                            .append("where longitude = :lon and latitude = :lat ")
                            .toString();
        
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("lon", lon)
                                    .addValue("lat", lat);

        return (CovidCase)template.queryForObject(sql, param, new BeanPropertyRowMapper(CovidCase.class));
    }
}