package org.zabus.fantasy.dal.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 20.09.2015.
 */
@Entity
public class Team {
    @Id
    private int teamID;
    private Integer currentPos;
    private String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Squad> squads;
    @OneToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "playerID")
    private Player player;

    public Team()
    {
        squads = new HashSet<Squad>();
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public Integer getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Integer currentPos) {
        this.currentPos = currentPos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Squad> getSquads() {
        return squads;
    }

    public void setSquads(Set<Squad> squads) {
        this.squads = squads;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
