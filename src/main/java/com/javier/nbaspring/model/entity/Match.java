package com.javier.nbaspring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "matches", schema = "nba", indexes = {
        @Index(name = "local_team", columnList = "local_team"),
        @Index(name = "visitor_team", columnList = "visitor_team")
})
public class Match {
    @Id
    @Column(name = "code", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_team")
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private com.javier.nbaspring.model.entity.Team localTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_team")
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private com.javier.nbaspring.model.entity.Team visitorTeam;

    @Column(name = "points_local")
    private Integer pointsLocal;

    @Column(name = "points_visitor")
    private Integer pointsVisitor;

    @Column(name = "season", length = 5)
    private String season;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.javier.nbaspring.model.entity.Team getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam(com.javier.nbaspring.model.entity.Team localTeam) {
        this.localTeam = localTeam;
    }

    public com.javier.nbaspring.model.entity.Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(com.javier.nbaspring.model.entity.Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public Integer getPointsLocal() {
        return pointsLocal;
    }

    public void setPointsLocal(Integer pointsLocal) {
        this.pointsLocal = pointsLocal;
    }

    public Integer getPointsVisitor() {
        return pointsVisitor;
    }

    public void setPointsVisitor(Integer pointsVisitor) {
        this.pointsVisitor = pointsVisitor;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

}