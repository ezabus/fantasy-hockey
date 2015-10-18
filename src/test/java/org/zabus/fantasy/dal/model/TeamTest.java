package org.zabus.fantasy.dal.model;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import org.junit.Assert;

/**
 * Created by user on 17.10.2015.
 */
public class TeamTest {

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
        Team team = em.find(Team.class, 1111);
        Assert.assertEquals("North Lake Wonders", team.getName());
        Assert.assertEquals("User", team.getPlayer().getName());
    }
}
