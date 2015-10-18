package org.zabus.fantasy.dal.model;

/**
 * Created by user on 17.10.2015.
 */
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import org.junit.Assert;

public class PlayerTest {
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
        Player player = em.find(Player.class, 111);
        Assert.assertEquals("User", player.getName());
    }
}
