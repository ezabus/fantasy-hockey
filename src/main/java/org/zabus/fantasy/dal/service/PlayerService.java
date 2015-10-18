package org.zabus.fantasy.dal.service;

/**
 * Created by user on 20.09.2015.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zabus.fantasy.dal.model.Player;
import org.zabus.fantasy.dal.repository.PlayerRepository;
import org.zabus.fantasy.dal.service.exeption.PlayerNotFoundException;


@Service
@Transactional
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player findOne(int id)
    {
        Player player = playerRepository.findOne(id);
        if(player != null)
        {
            player.getTeams().size();
        }
        return player;
    }

    public Iterable<Player> findAll()
    {
        return playerRepository.findAll();
    }

    public void save(Player player)
    {
        playerRepository.save(player);
    }


    public Player getPlayerFromDB(int id) throws PlayerNotFoundException
    {
        Player player = findOne(id);
        if(player == null)
        {
            throw new PlayerNotFoundException();
        }
        return player;
    }
}
