package org.zabus.fantasy.dal.model;

/**
 * Created by user on 20.09.2015.
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Squad {
    @Id
    private String squadID;
    private int points;
    private int dailyPoints;
    private int weeklyPoints;
    private int overalRank;
    private int dailyRank;
    private int weeklyRank;
    private String dateCode;
    @ManyToOne
    @JoinColumn(name = "teamID")
    private Team team;

    public String getSquadID() {
        return squadID;
    }

    public void setSquadID(String squadID) {
        this.squadID = squadID;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getDailyPoints() {
        return dailyPoints;
    }

    public void setDailyPoints(int dailyPoints) {
        this.dailyPoints = dailyPoints;
    }

    public int getOveralRank() {
        return overalRank;
    }

    public void setOveralRank(int overalRank) {
        this.overalRank = overalRank;
    }

    public int getDailyRank() {
        return dailyRank;
    }

    public void setDailyRank(int dailyRank) {
        this.dailyRank = dailyRank;
    }

    public int getWeeklyRank() {
        return weeklyRank;
    }

    public void setWeeklyRank(int weeklyRank) {
        this.weeklyRank = weeklyRank;
    }

    public int getWeeklyPoints() {
        return weeklyPoints;
    }

    public void setWeeklyPoints(int weeklyPoints) {
        this.weeklyPoints = weeklyPoints;
    }

    public String getDateCode() {
        return dateCode;
    }

    public void setDateCode(String dateCode) {
        this.dateCode = dateCode;
    }
}
