package com.travelBuddy.backend.travelBuddy.dao;

import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MakeCommentDaoImpl implements MakeCommentDao {

    private NamedParameterJdbcTemplate template;

    public MakeCommentDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void insertComment(MakeComment mc) {
        final String sql = new StringBuilder()
                            .append("insert into MakeComment")
                            .append("(ccontent, upvote, downvote, ")
                            .append("longitude, latitude, userid) ")
                            .append("values")
                            .append("(:ccontent, :upvote, :downvote, ")
                            .append(":longitude, :latitude, :userid)")
                            .toString();

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("ccontent", mc.getCcontent())
                                    .addValue("upvote", mc.getUpvote())
                                    .addValue("downvote", mc.getDownvote())
                                    .addValue("longitude", mc.getLongitude())
                                    .addValue("latitude", mc.getLatitude())
                                    .addValue("userid", mc.getUserId());
        template.update(sql, param, holder);
    }

    @Override
    public void updateUpvote(Long id) {
        MakeComment mc = findCommentById(id);
        mc.updateUpvote();
        final String sql = "update MakeComment set upvote=:upvote where id=:id";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", mc.getId())
                                    .addValue("upvote", mc.getUpvote());
        
        template.update(sql, param, holder);
    }

    @Override
    public void updateDownvote(Long  id) {
        MakeComment mc = findCommentById(id);
        mc.updateDownvote();
        final String sql = "update MakeComment set downvote=:downvote where id=:id";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", mc.getId())
                                    .addValue("downvote", mc.getDownvote());
        
        template.update(sql, param, holder);
    }

    @Override
    public MakeComment findCommentById(Long  id) {
        final String sql = "select * from MakeComment where id=:id";
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);
        
        return (MakeComment) template.queryForObject(sql, param, new BeanPropertyRowMapper(MakeComment.class));
    }
    
}