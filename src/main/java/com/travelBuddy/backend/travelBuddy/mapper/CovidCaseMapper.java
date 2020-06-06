package com.travelBuddy.backend.travelBuddy.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.travelBuddy.backend.travelBuddy.entity.CovidCase;

public class CovidCaseMapper implements RowMapper<CovidCase> {

    @Override
    public CovidCase mapRow(ResultSet rs, int arg1) throws SQLException {
        CovidCase cc = new CovidCase();
        cc.setId(rs.getString("id"));
        cc.setLongitude(rs.getFloat("longitude"));
        cc.setLatitude(rs.getFloat("latitude"));
        cc.setCaseType(rs.getString("casetype"));

        return cc;
    }
}