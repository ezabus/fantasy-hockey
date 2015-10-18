package org.zabus.fantasy.dal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zabus.fantasy.dal.model.Squad;

/**
 * Created by user on 11.09.2015.
 */
@Repository
public interface SquadRepository extends CrudRepository<Squad, String>{
    public Iterable<Squad> findSquadByTeamTeamID(int teamID);
    public Iterable<Squad> findSquadByDateCode(String dateCode);
    public Iterable<Squad> findTop100SquadByDateCodeOrderByDailyRank(String dateCode);
    public Iterable<Squad> findTop100SquadByDateCodeOrderByWeeklyRank(String dateCode);
    public Iterable<Squad> findSquadByTeamTeamIDAndDateCodeBetween(int teamID, String fromDateCode, String toDateCode);
}
