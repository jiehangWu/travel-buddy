package com.travelBuddy.backend.travelBuddy.mapper;

import com.travelBuddy.backend.travelBuddy.entity.Postcode;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostcodeRowMapper implements RowMapper<Postcode> {

    @Override
    public Postcode mapRow(ResultSet rs, int arg1) throws SQLException {
        Postcode pc = new Postcode();
        pc.setCity(rs.getString("city"));
        pc.setCountry(rs.getString("country"));
        pc.setCode(rs.getString("code"));

        return pc;
    }
}
