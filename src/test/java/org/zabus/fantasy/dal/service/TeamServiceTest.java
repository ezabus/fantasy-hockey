package org.zabus.fantasy.dal.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zabus.fantasy.dal.model.Team;
import org.zabus.fantasy.dal.service.exeption.TeamNotFoundException;

/**
 * Created by user on 17.10.2015.
 */
public class TeamServiceTest {

    static TeamService teamService;

    @BeforeClass
    public static void setUp()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hockey.xml");
        context.getEnvironment().setActiveProfiles("develop");
        context.refresh();
        teamService = (TeamService) context.getBean("teamService");
    }

    @Test
    public void testSaveAndFind()
    {
        int teamId = 222;
        String name = "Direwolves";
        Team team = new Team();
        team.setTeamID(teamId);
        team.setName(name);
        teamService.save(team);
        try {
            Team foundTeam = teamService.getTeamFromDB(222);
            Assert.assertEquals(name, foundTeam.getName());
        } catch (TeamNotFoundException e) {
            e.printStackTrace();
        }


    }
}
