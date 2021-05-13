package pl.juniorjavadeveloper.examples.hibernate.basic.entity.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HibernateNativeEntityModelTest {
    private SessionFactory sessionFactory;

    @BeforeEach
    void setUp() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        try {
            sessionFactory = new MetadataSources(serviceRegistry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    @AfterEach
    void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    void given_when_then() {
        // given
        // NOTE: sessionFactory initialized in setUp() method...

        // when
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable savedId = session.save(new Animal(new Date(), "Elephant"));
        session.getTransaction().commit();
        session.close();

        // then
        assertNotNull(savedId, "savedId is null");
    }
}
