package org.zabus.fantasy.web;

import com.google.common.collect.Lists;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zabus.fantasy.dal.model.Squad;
import org.zabus.fantasy.dal.model.Team;
import org.zabus.fantasy.dal.service.SquadService;
import org.zabus.fantasy.dal.service.exeption.SquadNotFoundException;
import org.zabus.fantasy.utils.DateUtils;

import java.util.*;

/**
 * Created by user on 13.10.2015.
 */
@Controller
public class HistController {

    @Autowired
    SquadService squadService;
    private final Logger logger = LoggerFactory.getLogger(AchivController.class);

    @RequestMapping(value = "/hist", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Squad> getAllSquads(@RequestParam("teamID") int teamID, @RequestParam("month") int monthNumber)
    {
        logger.info("history for team " + teamID + " and month " + monthNumber);
        String fromDate = DateUtils.getFirstDayOfMonth(monthNumber);
        String toDate = DateUtils.getLastDayOfMounth(monthNumber);
        Iterable<Squad> squads = squadService.getSquadByTeamIDAndMounth(teamID,fromDate,toDate);
        for(Squad s : squads)
        {
            s.setTeam(new Team());
        }
        return squads;
    }

    @RequestMapping(value="/weekhist", method = RequestMethod.GET)
    @ResponseBody
    public List<Squad> getAllMondays(@RequestParam("teamID") int teamID)
    {
        logger.info("week history for team " + teamID);
        Set mondaySet = DateUtils.getMondaySet();
        List<Squad> squads = new LinkedList<Squad>();
        List<Squad> mondays = new LinkedList<Squad>();
        try {
            squads = Lists.newLinkedList(squadService.getSquadsByTeamId(teamID));
            for(Squad s : squads)
            {
                if(mondaySet.contains(s.getDateCode())) {
                    s.setTeam(new Team());
                    s.setDateCode(DateUtils.getWeekRange(s.getDateCode()));
                    mondays.add(s);
                }
            }
        } catch (SquadNotFoundException e) {
            logger.info("Wrong teamID: " + teamID);
        }
        return mondays;
    }

    @RequestMapping(value="/chart", method = RequestMethod.GET)
    @ResponseBody
    public long[][] chartControllerMock(@RequestParam("teamID") int teamID)
    {
        long data[][] = null;
        try {
            List<Squad> squads = Lists.newLinkedList(squadService.getSquadsByTeamId(teamID));
            data = new long[squads.size()][2];
            for(int i = 0; i < squads.size(); i++)
            {
                data[i][0] = DateUtils.getTimestampValue(squads.get(i).getDateCode());
                data[i][1] = squads.get(i).getOveralRank();
            }
        } catch (SquadNotFoundException e) {
            e.printStackTrace();
        }
        return data;
//        int data[][] = new int[5][2];
//        data[0][0] = 1;
//        data[0][1] = 10;
//        data[1][0] = 2;
//        data[1][1] = 15;
//        data[2][0] = 3;
//        data[2][1] = 7;
//        data[3][0] = 0;
//        data[3][1] = 5;
    }
}
