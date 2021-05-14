package pl.juniorjavadeveloper.examples.hibernate.basic.relationship.many_to_many;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HibernateJpaRelationshipManyToManyTest {
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
        entityManager.getTransaction().begin();

        Person person = new Person("John", "Doe");
        person.addAddress(new Address("1st Avenue", "00111"));
        person.addAddress(new Address("3rd Street", "00333"));

        entityManager.persist(person);
        entityManager.getTransaction().commit();

        // then
        assertNotNull(entityManager, "EntityManager is null");
    }
}
