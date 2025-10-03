package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "idol")
public class Idol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idol_name")
    @JsonProperty("idol_name")
    private String idol_name;
    
    @Column(name = "vote_count")
    @JsonProperty("vote_count")
    private Integer vote_count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdolName() {
        return idol_name;
    }

    public void setIdolName(String idol_name) {
        this.idol_name= idol_name;
    }

    public Integer getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(Integer vote_count) {
        this.vote_count = vote_count;
    }
}
