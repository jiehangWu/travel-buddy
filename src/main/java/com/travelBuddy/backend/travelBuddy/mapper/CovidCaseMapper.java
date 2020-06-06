package com.travelBuddy.backend.travelBuddy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.travelBuddy.backend.travelBuddy.entity.CovidCase;

public class CovidCaseMapper implements RowMapper<CovidCase> {

    @Override
    public CovidCase mapRow(ResultSet rs, int arg1) throws SQLException {
        CovidCase cc = new CovidCase();
        String id, caseType;
        float longitude, latitude;
        int count;

        try {
            id = rs.getString("id");
            cc.setId(id);
        } catch(SQLException e) {
            id = null;
        }

        try {
            longitude = rs.getFloat("longitude");
            cc.setLongitude(longitude);
        } catch(SQLException e) {
            longitude = 0;
        }

        try {
            latitude = rs.getFloat("latitude");
            cc.setLatitude(latitude);
        } catch(SQLException e) {
            latitude = 0;
        }
        
        try {
            caseType = rs.getString("casetype");
            cc.setCaseType(caseType);
        } catch(SQLException e) {
            caseType = null;
        }

        try {
            count = rs.getInt("count");
            cc.setCount(count);
        } catch(SQLException e) {
            count = 0;
        }
         
        return cc;
    }
}