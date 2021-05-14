package pl.juniorjavadeveloper.examples.hibernate.basic.relationship.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HibernateNativeRelationshipOneToManyTest {
    private SessionFactory sessionFactory;

    @BeforeEach
    void setUp() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
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

        Menu menu = new Menu("Main menu", "Appetizer, Soup, Main course");
        menu.addItem(new Item("Caprese Salad", 12.99f));
        menu.addItem(new Item("Tomato soup", 20.99f));

        Serializable savedId = session.save(menu);
        session.getTransaction().commit();
        session.close();

        // then
        assertNotNull(savedId, "savedId Menu is null");
    }
}
