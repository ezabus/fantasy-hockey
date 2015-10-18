package org.zabus.fantasy.dal.model;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import org.junit.Assert;

/**
 * Created by user on 16.10.2015.
 */
public class SquadTest {

    static EntityManagerFactory emf;
    static EntityManager em;

    @BeforeClass
    public static void setUp()
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hockey.xml");
        context.getEnvironment().setActiveProfiles("develop");
        context.refresh();
        emf = (EntityManagerFactory) context.getBean("entityManagerFactory");
        em = emf.createEntityManager();
    }

    @Test
    public void testEntity()
    {
        Squad squad = em.find(Squad.class, "1111_2015/10/16");
//        INSERT INTO squad (squadID, dailyPoints, weeklyPoints, overalRank, dailyRank, weeklyRank, dateCode)
//        VALUES ('1111_2015/10/16',100, 300, 10, 20, 15, '2015/10/16');
        Assert.assertEquals(500, squad.getPoints());
        Assert.assertEquals(100, squad.getDailyPoints());
        Assert.assertEquals(300, squad.getWeeklyPoints());
        Assert.assertEquals(10, squad.getOveralRank());
        Assert.assertEquals(20, squad.getDailyRank());
        Assert.assertEquals(15, squad.getWeeklyRank());
        Assert.assertEquals("2015/10/16", squad.getDateCode());
        Assert.assertEquals("North Lake Wonders", squad.getTeam().getName());
    }
}
