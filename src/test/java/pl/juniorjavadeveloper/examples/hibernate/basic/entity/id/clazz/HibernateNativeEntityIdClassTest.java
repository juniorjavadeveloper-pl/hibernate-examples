package pl.juniorjavadeveloper.examples.hibernate.basic.entity.id.clazz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HibernateNativeEntityIdClassTest {
    private SessionFactory sessionFactory;

    @BeforeEach
    protected void setUp() {
        final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
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

    @BeforeEach
    protected void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void given_when_then() {
        // given
        // NOTE: sessionFactory initialized in setUp() method...

        // when
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String vin = "1234ABC";
        String registrationNumber = "NBA 1234";
        VehicleIdClass vehicleIdClass = new VehicleIdClass(vin, registrationNumber);
        Serializable savedId = session.save(new Vehicle(vin, registrationNumber));
        session.getTransaction().commit();
        session.close();

        // then
        assertNotNull(savedId, "savedId is null");
    }
}
