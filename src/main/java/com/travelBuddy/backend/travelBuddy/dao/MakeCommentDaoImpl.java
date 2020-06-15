package com.travelBuddy.backend.travelBuddy.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.AppUser;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCallback;
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
    public void updateUpvote(int id) {
        final String sql = "update MakeComment set upvote = upvote + 1 where id=:id";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);
        
        template.update(sql, param, holder);
    }

    @Override
    public void updateDownvote(int id) {
        final String sql = "update MakeComment set downvote = downvote + 1 where id=:id";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);
        
        template.update(sql, param, holder);
    }

    @Override
    public MakeComment findCommentById(Long  id) {
        final String sql = "select * from MakeComment where id=:id";
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);
        
        return (MakeComment) template.queryForObject(sql, param, new BeanPropertyRowMapper(MakeComment.class));
    }

    @Override
    public void deleteCommentById(int id) {
        final String sql = "delete from makecomment where id = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);
        
        template.execute(sql, param, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    @Override
    public List<MakeComment> findAllComments() {
        final String sql = "select * from  makecomment";
        return (List<MakeComment>)template.query(sql, new BeanPropertyRowMapper(MakeComment.class));
    }

    @Override
    public AppUser findAppUserByUserId(int id) {
        final String sql = "select distinct u.username from AppUser u, makecomment m where m.userid = u.id and m.userid = :id";
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);

        return (AppUser)template.queryForObject(sql, param, new BeanPropertyRowMapper(AppUser.class));
    }     
    
    public int findUpvoteById(int id) {
        final String sql = "select upvote from makecomment where id=:id";
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);
        return (int)template.queryForObject(sql, param, Integer.class);
    }

    public int findDownvoteById(int id) {
        final String sql = "select downvote from makecomment where id=:id";
        SqlParameterSource param = new MapSqlParameterSource()
                                    .addValue("id", id);
        return (int)template.queryForObject(sql, param, Integer.class);
    }
}