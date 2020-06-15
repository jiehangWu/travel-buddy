package com.travelBuddy.backend.travelBuddy.dao;

import com.travelBuddy.backend.travelBuddy.entity.AppUser;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserDaoImpl implements AppUserDao {
    private NamedParameterJdbcTemplate template;

    public AppUserDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public AppUser findAppUserById(int id) {
        final String sql = "select * from appuser where id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);
        
        return (AppUser)template.queryForObject(sql, param, new BeanPropertyRowMapper(AppUser.class));
                                   
    }
}