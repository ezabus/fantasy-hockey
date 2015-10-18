package org.zabus.fantasy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zabus.fantasy.dal.model.Squad;
import org.zabus.fantasy.dal.service.SquadService;
import org.zabus.fantasy.dal.service.exeption.SquadNotFoundException;
import org.zabus.fantasy.utils.DateUtils;

import java.util.Set;

/**
 * Created by user on 29.09.2015.
 */

@Controller
public class AchivController {

    @Autowired
    SquadService squadService;
    private final Logger logger = LoggerFactory.getLogger(AchivController.class);

    @RequestMapping(value = "/dayachivs", method = RequestMethod.GET)
    @ResponseBody
    public int[] getDailyAchivs(@RequestParam("teamID") int teamID)
    {
        int[] achivsArr = new int[4];
        try {
            Iterable<Squad> squads = squadService.getSquadsByTeamId(teamID);
            for (Squad squad : squads) {
                int dailyRank = squad.getDailyRank();
                if (dailyRank != 0) {
                    if (dailyRank == 1) {
                        achivsArr[0]++;
                    }
                    if (dailyRank <= 3) {
                        achivsArr[1]++;
                    }
                    if (dailyRank <= 10) {
                        achivsArr[2]++;
                    }
                    if (dailyRank <= 100) {
                        achivsArr[3]++;
                    }
                }
            }
        } catch (SquadNotFoundException e) {
            logger.info("Wrong teamID: "  + teamID);
        }
        return achivsArr;
    }

    @RequestMapping(value = "/weekachivs", method = RequestMethod.GET)
    @ResponseBody
    public int[] getWeeklyAchivs(@RequestParam("teamID") int teamID)
    {
        int[] achivsArr = new int[4];
        try {
            Iterable<Squad> squads = squadService.getSquadsByTeamId(teamID);
            Set mondaySet = DateUtils.getMondaySet();
            for (Squad squad : squads) {
                int weeklyRank = squad.getWeeklyRank();
                if ((weeklyRank != 0) && (mondaySet.contains(squad.getDateCode()))) {
                    if (weeklyRank == 1) {
                        achivsArr[0]++;
                    }
                    if (weeklyRank <= 3) {
                        achivsArr[1]++;
                    }
                    if (weeklyRank <= 10) {
                        achivsArr[2]++;
                    }
                    if (weeklyRank <= 100) {
                        achivsArr[3]++;
                    }
                }
            }
        } catch (SquadNotFoundException e) {
            logger.info("Wrong teamID: " + teamID);
        }
        return achivsArr;
    }

    @RequestMapping(value = "/seasonachivs", method = RequestMethod.GET)
    @ResponseBody
    public int[] getOveralAchivs(@RequestParam("teamID") int teamID)
    {
        int[] achivsArr = new int[4];
        try {
            Iterable<Squad> squads = squadService.getSquadsByTeamId(teamID);
            for (Squad squad : squads) {
                int overalRank = squad.getOveralRank();
                if (overalRank != 0) {
                    if (overalRank == 1) {
                        achivsArr[0]++;
                    }
                    if (overalRank <= 10) {
                        achivsArr[1]++;
                    }
                    if (overalRank <= 100) {
                        achivsArr[2]++;
                    }
                    if (overalRank <= 500) {
                        achivsArr[3]++;
                    }
                }
            }
        } catch (SquadNotFoundException e) {
            logger.info("Wrong teamID: " + teamID);
        }
        return achivsArr;
    }
}
