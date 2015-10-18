package org.zabus.fantasy.dal.model;

/**
 * Created by user on 20.09.2015.
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    private int playerID;
    private String name;
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<Team> teams;

    public Player()
    {
        teams = new HashSet<Team>();
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
