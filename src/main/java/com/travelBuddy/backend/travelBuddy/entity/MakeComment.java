package com.travelBuddy.backend.travelBuddy.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class MakeComment {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
        name = "uuid2",
        strategy = "uuid2"
    )
    @Column(name = "cid", updatable = false, nullable = false, columnDefinition = "uuid")
    private UUID cid;

    private String ccontent;
    private int upvote, downvote;
    private float longitude, latitude;
    private UUID userid;

    public MakeComment() {
        upvote = 0;
        downvote = 0;
    }
    
    public UUID getId() {
        return cid;
    }

    public void setId(UUID cid) {
        this.cid = cid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public int getUpvote() {
        return upvote;
    }

    public void updateUpvote() {
        upvote += 1;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void updateDownvote() {
        downvote += 1;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public UUID getUserId() {
        return userid;
    }

    public void setUserId(UUID userid) {
        this.userid = userid;
    }
}