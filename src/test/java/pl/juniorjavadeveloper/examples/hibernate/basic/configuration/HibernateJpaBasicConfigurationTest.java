package pl.juniorjavadeveloper.examples.hibernate.basic.configuration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HibernateJpaBasicConfigurationTest {
    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory(
                "pl.juniorjavadeveloper.examples.hibernate.basic.configuration.pu");
    }

    @AfterEach
    void tearDown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    void given_when_then() {
        // given
        // NOTE: entityManagerFactory initialized in setUp() method...

        // when
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.close();

        // then
        assertNotNull(entityManager, "EntityManager is null");
    }
}
