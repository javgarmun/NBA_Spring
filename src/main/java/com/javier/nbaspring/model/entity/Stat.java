package com.javier.nbaspring.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stats", schema = "nba", indexes = {
        @Index(name = "player", columnList = "player")
})
public class Stat {
    @EmbeddedId
    private StatId id;

    @MapsId("player")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "player", nullable = false)
    private Player player;

    @Column(name = "Points_per_match")
    private Float pointsPerMatch;

    @Column(name = "Assistances_per_match")
    private Float assistancesPerMatch;

    @Column(name = "Blocks_per_match")
    private Float blocksPerMatch;

    @Column(name = "Rebound_per_match")
    private Float reboundPerMatch;

    public StatId getId() {
        return id;
    }

    public void setId(StatId id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Float getPointsPerMatch() {
        return pointsPerMatch;
    }

    public void setPointsPerMatch(Float pointsPerMatch) {
        this.pointsPerMatch = pointsPerMatch;
    }

    public Float getAssistancesPerMatch() {
        return assistancesPerMatch;
    }

    public void setAssistancesPerMatch(Float assistancesPerMatch) {
        this.assistancesPerMatch = assistancesPerMatch;
    }

    public Float getBlocksPerMatch() {
        return blocksPerMatch;
    }

    public void setBlocksPerMatch(Float blocksPerMatch) {
        this.blocksPerMatch = blocksPerMatch;
    }

    public Float getReboundPerMatch() {
        return reboundPerMatch;
    }

    public void setReboundPerMatch(Float reboundPerMatch) {
        this.reboundPerMatch = reboundPerMatch;
    }

}