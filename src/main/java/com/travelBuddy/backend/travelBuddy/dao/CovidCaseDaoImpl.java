package com.travelBuddy.backend.travelBuddy.dao;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.CovidCase;
import com.travelBuddy.backend.travelBuddy.mapper.CovidCaseMapper;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CovidCaseDaoImpl implements CovidCaseDao {

    private NamedParameterJdbcTemplate template;
    
    public CovidCaseDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<CovidCase> findAndGroupCovidCases() {
        String query = new StringBuilder()
                        .append("select longitude lon, latitude lat, count(*)")
                        .append("from covidcase group by (lon, lat)")
                        .toString();

        return template.query(query, new CovidCaseMapper());
    }

    @Override
    public List<CovidCase> findCovidCasesByCaseType(String caseType) {
        String query = new StringBuilder()
                        .append("select longitude lon, latitude lat, count(*)")
                        .append("from covidcase where casetype = ")
                        .append(caseType)
                        .append(" group by (lon, lat)")
                        .toString();
        
        return template.query(query, new CovidCaseMapper());
    }

}