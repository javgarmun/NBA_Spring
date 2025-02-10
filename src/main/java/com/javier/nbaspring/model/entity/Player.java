package com.javier.nbaspring.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "players", schema = "nba", indexes = {
        @Index(name = "Team_name", columnList = "Team_name")
})
public class Player {
    @Id
    @Column(name = "code", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 30)
    private String name;

    @Column(name = "Origin", length = 20)
    private String origin;

    @Column(name = "Height", length = 4)
    private String height;

    @Column(name = "Weight")
    private Integer weight;

    @Column(name = "Position", length = 5)
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Team_name")
    @JsonIgnoreProperties({"hibernateLazyInitializer","players"})
    private Team teamName;

    @Column(name = "Salary")
    private Integer salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public com.javier.nbaspring.model.entity.Team getTeamName() {
        return teamName;
    }

    public void setTeamName(com.javier.nbaspring.model.entity.Team teamName) {
        this.teamName = teamName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}