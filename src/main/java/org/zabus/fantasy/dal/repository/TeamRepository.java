package org.zabus.fantasy.dal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zabus.fantasy.dal.model.Team;

/**
 * Created by user on 12.09.2015.
 */
@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {
}
