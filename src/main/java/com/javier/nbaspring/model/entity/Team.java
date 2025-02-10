package com.javier.nbaspring.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams", schema = "nba")
public class Team {
    @Id
    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "City", length = 20)
    private String city;

    @Column(name = "Conference", length = 4)
    private String conference;

    @Column(name = "Division", length = 9)
    private String division;

    @OneToMany(mappedBy = "teamName", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}