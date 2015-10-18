package org.zabus.fantasy.dal.service;

/**
 * Created by user on 20.09.2015.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zabus.fantasy.dal.model.Squad;
import org.zabus.fantasy.dal.repository.SquadRepository;
import org.zabus.fantasy.dal.service.exeption.SquadNotFoundException;
import org.zabus.fantasy.utils.DateUtils;


@Service
@Transactional
public class SquadService {
    @Autowired
    private SquadRepository squadRepository;

    public Squad findOne(String squadID)
    {
        return squadRepository.findOne(squadID);
    }

    public void save(Squad squad)
    {
        squadRepository.save(squad);
    }

    public Squad getSquad(int teamID, String dayCode) throws SquadNotFoundException
    {
        Squad squad = squadRepository.findOne(teamID + "_" + dayCode);
        if(squad == null)
        {
            throw new SquadNotFoundException();
        }
        return squad;
    }

    public Squad getLatestSquad(int teamID) throws SquadNotFoundException
    {
        Squad squad;
        try {
            squad = getSquadByDate(teamID, DateUtils.getTodayDate());
        } catch (SquadNotFoundException e) {
            squad = getSquadByDate(teamID, DateUtils.getYesterdayDate());
        }
        return squad;
    }

    public Squad getSquadByDate(int teamID, String dateCode) throws SquadNotFoundException
    {
        Squad squad = findOne(String.valueOf(teamID) + "_" + dateCode);
        if(squad == null)
        {
            throw new SquadNotFoundException();
        }
        return squad;
    }

    public Iterable<Squad> getSquadsByTeamId(int teamID) throws SquadNotFoundException
    {
        Iterable<Squad> squads = squadRepository.findSquadByTeamTeamID(teamID);
        if(squads == null)
        {
            throw new SquadNotFoundException();
        }
        return squads;
    }

    public Iterable<Squad> findSquadByDateCode(String dateCode)
    {
        return squadRepository.findSquadByDateCode(dateCode);
    }

    public Iterable<Squad> getTop100DailyResults(String dateCode)
    {
        return squadRepository.findTop100SquadByDateCodeOrderByDailyRank(dateCode);
    }

    public Iterable<Squad> getTop100WeeklyResults(String dateCode)
    {
        return squadRepository.findTop100SquadByDateCodeOrderByWeeklyRank(dateCode);
    }

    public Iterable<Squad> getSquadByTeamIDAndMounth(int teamID, String fromDateCode, String toDateCode)
    {
        return squadRepository.findSquadByTeamTeamIDAndDateCodeBetween(teamID, fromDateCode, toDateCode);
    }
}
