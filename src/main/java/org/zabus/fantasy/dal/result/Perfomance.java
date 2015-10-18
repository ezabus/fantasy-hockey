package org.zabus.fantasy.dal.result;

/**
 * Created by user on 25.09.2015.
 */
public class Perfomance {
    private int dailyPoints;
    private String name;
    private int pos;
    private int teamID;

    public Perfomance(int dailyPoints, String name, int pos, int teamID) {
        this.dailyPoints = dailyPoints;
        this.name = name;
        this.pos = pos;
        this.teamID = teamID;
    }

    public Perfomance()
    {

    }

    public int getDailyPoints() {
        return dailyPoints;
    }

    public void setDailyPoints(int dailyPoints) {
        this.dailyPoints = dailyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }
}
