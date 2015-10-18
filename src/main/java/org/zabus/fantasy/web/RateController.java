package org.zabus.fantasy.web;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zabus.fantasy.dal.result.Perfomance;
import org.zabus.fantasy.dal.model.Player;
import org.zabus.fantasy.dal.model.Squad;
import org.zabus.fantasy.dal.model.Team;
import org.zabus.fantasy.dal.service.PlayerService;
import org.zabus.fantasy.dal.service.SquadService;
import org.zabus.fantasy.dal.service.TeamService;
import org.zabus.fantasy.dal.service.exeption.SquadNotFoundException;
import org.zabus.fantasy.dal.service.exeption.TeamNotFoundException;
import org.zabus.fantasy.utils.DateUtils;

import java.util.*;

@Controller
public class RateController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    @Autowired
    PlayerService playerService;
    @Autowired
    SquadService squadService;
    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/dtop", method = RequestMethod.GET)
    @ResponseBody
    public List<Perfomance> getTop100Daily(@RequestParam(required = false) String dateCode)
    {
        logger.info("get100Daily() called");
        List<Perfomance> perfomances;
        if(dateCode == null)
        {
            perfomances = getLatestTop100Daily();
        } else {
            perfomances = getTop100DailyByDate(dateCode);
        }
        return perfomances;
    }

    public List<Perfomance> getLatestTop100Daily()
    {
        List<Squad> squads = Lists.newLinkedList(squadService.getTop100DailyResults(DateUtils.getTodayDate()));
        if(squads.size() == 0)
        {
            squads = Lists.newLinkedList(squadService.getTop100DailyResults(DateUtils.getYesterdayDate()));
        }
        List<Perfomance> perfomances = new LinkedList<Perfomance>();
        for(Squad squad : squads)
        {
            Perfomance perfomance = new Perfomance(squad.getDailyPoints(),squad.getTeam().getPlayer().getName(),
                    squad.getOveralRank(),squad.getTeam().getTeamID());
            perfomances.add(perfomance);
        }
        return perfomances;
    }

    public List<Perfomance> getTop100DailyByDate(String dateCode)
    {
        List<Squad> squads = Lists.newLinkedList(squadService.getTop100DailyResults(dateCode));
        List<Perfomance> perfomances = new LinkedList<Perfomance>();
        if(squads.size() == 0)
        {
            perfomances = getLatestTop100Daily();
        } else
        {
            for (Squad squad : squads) {
                Perfomance perfomance = new Perfomance(squad.getDailyPoints(), squad.getTeam().getPlayer().getName(),
                        squad.getOveralRank(), squad.getTeam().getTeamID());
                perfomances.add(perfomance);
            }
        }
        return perfomances;
    }

    @RequestMapping(value = "/wtop", method = RequestMethod.GET)
    @ResponseBody
    public List<Perfomance> getTop100Weekly(@RequestParam(required = false) String dateCode)
    {
        logger.info("getTop100Weekly() called");
        List<Perfomance> perfomances;
        if(dateCode == null)
        {
            perfomances = getLatestTop100Weekly();
        } else {
            perfomances = getTop100WeeklyByDate(dateCode);
        }
        return perfomances;
    }

    public List<Perfomance> getTop100WeeklyByDate(String dateCode)
    {
        logger.info("getTop100Weekly() called for date " + dateCode);
        List<Squad> squads = Lists.newLinkedList(squadService.getTop100WeeklyResults(dateCode));
        List<Perfomance> perfomances = new LinkedList<Perfomance>();
        if(squads.size() == 0)
        {
            perfomances = getLatestTop100Weekly();
        } else {
            for (Squad squad : squads) {
                Perfomance perfomance = new Perfomance(squad.getWeeklyPoints(), squad.getTeam().getPlayer().getName(),
                        squad.getOveralRank(), squad.getTeam().getTeamID());
                perfomances.add(perfomance);
            }
        }
        return perfomances;
    }

    public List<Perfomance> getLatestTop100Weekly()
    {
        List<Squad> squads = Lists.newLinkedList(squadService.getTop100WeeklyResults(DateUtils.getTodayDate()));
        if(squads.size() == 0)
        {
            squads = Lists.newLinkedList(squadService.getTop100WeeklyResults(DateUtils.getYesterdayDate()));
        }
        List<Perfomance> perfomances = new LinkedList<Perfomance>();
        for(Squad squad : squads)
        {
            Perfomance perfomance = new Perfomance(squad.getWeeklyPoints(),squad.getTeam().getPlayer().getName(),
                    squad.getOveralRank(), squad.getTeam().getTeamID());
            perfomances.add(perfomance);
        }
        return perfomances;
    }

    @RequestMapping(value = "/pointsrank", method = RequestMethod.GET)
    @ResponseBody
    public Squad getPointsAndRanks(@RequestParam("teamID") int teamID)
    {
        logger.info("teamID: " + teamID);
        Squad squad = new Squad();
        try {
            squad = squadService.getLatestSquad(teamID); //CHANGE TO TODAY!!!
        } catch (SquadNotFoundException e) {
            logger.info("squad not found for teamID: " + teamID);
        }
        squad.setTeam(new Team());
        return squad;
    }

    @RequestMapping(value = "/playerinfo", method = RequestMethod.GET)
    @ResponseBody
    public Team getPlayerInfo(@RequestParam("teamID") int teamID)
    {
        logger.info("teamID: " + teamID);
        Team team = new Team();
        try {
            team = teamService.getTeamFromDB(teamID);
            team.setSquads(new HashSet<Squad>());
            team.setName(team.getPlayer().getName());
            team.setPlayer(new Player());
        } catch (TeamNotFoundException e) {
            logger.info("team not found for teamID: " + teamID);
        }
        return team;
    }

    @RequestMapping(value = "/achivs", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getAchivs(@RequestParam("period") String period)
    {
        Map<String,String> achivs = new HashMap<String, String>();

        return achivs;
    }

}
