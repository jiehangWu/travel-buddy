package com.travelBuddy.backend.travelBuddy.dao;

import com.travelBuddy.backend.travelBuddy.entity.Postcode;
import com.travelBuddy.backend.travelBuddy.mapper.PostcodeRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostcodeDaoImpl implements PostcodeDao {

    private NamedParameterJdbcTemplate template;

    public PostcodeDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Postcode> findAll() {
        return template.query("select * from postcode", new PostcodeRowMapper());
    }
}
