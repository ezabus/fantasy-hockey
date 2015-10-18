package org.zabus.fantasy.dal.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import org.junit.Assert;
import org.zabus.fantasy.dal.model.Player;
import org.zabus.fantasy.dal.service.exeption.PlayerNotFoundException;


/**
 * Created by user on 17.10.2015.
 */
public class PlayerServiceTest {

    static PlayerService playerService;

    @BeforeClass
    public static void setUp()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hockey.xml");
        context.getEnvironment().setActiveProfiles("develop");
        context.refresh();
        playerService = (PlayerService) context.getBean("playerService");
    }

    @Test
    public void testGetPlayerFromDB()
    {
        try {
            Player player = playerService.getPlayerFromDB(111);
            Assert.assertEquals("User", player.getName());
        } catch (PlayerNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPlayerFromDbWithException()
    {
        Player player = new Player();
        try {
            player = playerService.getPlayerFromDB(1111);
        } catch (PlayerNotFoundException e) {
            Assert.assertNull(player.getName());
        }
    }

    @Test
    public void testFindOne()
    {
        Player player = playerService.findOne(111);
        Assert.assertEquals("User", player.getName());
    }

    @Test
    public void testFindAll()
    {
        Iterable<Player> players = playerService.findAll();
        for(Player player : players)
        {
            Assert.assertNotNull(player.getName());
        }
    }
}
