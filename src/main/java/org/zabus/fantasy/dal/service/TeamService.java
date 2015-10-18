package org.zabus.fantasy.dal.service;

/**
 * Created by user on 20.09.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zabus.fantasy.dal.model.Team;
import org.zabus.fantasy.dal.repository.TeamRepository;
import org.zabus.fantasy.dal.service.exeption.TeamNotFoundException;

@Service
@Transactional
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public void save(Team team)
    {
        teamRepository.save(team);
    }

    public Team findOne(int teamID)
    {
        Team team = teamRepository.findOne(teamID);
        if(team != null)
        {
            team.getSquads().size();
        }
        return team;
    }

    public Team getTeamFromDB(int teamID) throws TeamNotFoundException
    {
        Team team = findOne(teamID);
        if(team == null)
        {
            throw new TeamNotFoundException();
        }
        return team;
    }

    public Iterable<Team> findAll()
    {
        return teamRepository.findAll();
    }
}
