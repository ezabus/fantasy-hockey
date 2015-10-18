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
import org.zabus.fantasy.dal.model.Team;
import org.zabus.fantasy.dal.service.SquadService;
import org.zabus.fantasy.utils.DateUtils;

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
        String fromDate = DateUtils.getLastDayOfLastMonth(monthNumber);
        String toDate = DateUtils.getLastDayOfMounth(monthNumber);
        Iterable<Squad> squads = squadService.getSquadByTeamIDAndMounth(teamID,fromDate,toDate);
        for(Squad s : squads)
        {
            s.setTeam(new Team());
        }
        return squads;
    }

}
