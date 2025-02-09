package com.javier.nbaspring.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class StatId implements java.io.Serializable {
    private static final long serialVersionUID = 1036060187005612768L;
    @Column(name = "season", nullable = false, length = 5)
    private String season;

    @Column(name = "player", nullable = false)
    private Integer player;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getPlayer() {
        return player;
    }

    public void setPlayer(Integer player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StatId entity = (StatId) o;
        return Objects.equals(this.season, entity.season) &&
                Objects.equals(this.player, entity.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(season, player);
    }

}