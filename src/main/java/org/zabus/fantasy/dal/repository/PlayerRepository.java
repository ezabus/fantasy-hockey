package org.zabus.fantasy.dal.repository;

/**
 * Created by user on 13.09.2015.
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zabus.fantasy.dal.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

}
