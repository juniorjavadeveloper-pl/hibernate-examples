package pl.juniorjavadeveloper.examples.hibernate.basic.hql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HibernateJpaHqlTest {
    private static final int CLIENTS_NUMBER = 5;
    private static final int CLIENTS_JOIN_ORDER_NUMBER = 1;
    private static final int CLIENT_LABELS = 3;
    private static final int CLIENT_DRIVER_LABELS = 2;
    private static final String CLIENT_LABEL_DRIVER = "Driver";
    private static final String CLIENT_LABEL_OFFICE_WORKER = "Office Worker";

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory(
                "pl.juniorjavadeveloper.examples.hibernate.basic.configuration.pu");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Client johnClient = new Client("John", "Millionaire", 36);
        johnClient.addOrder(new Order("Juice", 12.99, 2));
        johnClient.addOrder(new Order("Coffee", 22.99, 1));

        Client andrewClient = new Client("Andrew", CLIENT_LABEL_OFFICE_WORKER, 26);
        andrewClient.addOrder(new Order("A4 Paper Sheet", 10.88, 5));

        Client annaClient = new Client("Anna", CLIENT_LABEL_OFFICE_WORKER, 28);
        annaClient.addOrder(new Order("Staples", 10.88, 10));

        Client maxClient = new Client("Max", CLIENT_LABEL_DRIVER, 21);
        Client samClient = new Client("Sam", CLIENT_LABEL_DRIVER, 20);

        entityManager.persist(johnClient);
        entityManager.persist(andrewClient);
        entityManager.persist(annaClient);
        entityManager.persist(maxClient);
        entityManager.persist(samClient);
        entityManager.getTransaction().commit();
    }

    @AfterEach
    void tearDown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    void given_whenFrom_then() {
        // given
        // NOTE: entityManagerFactory initialized in setUp() method...

        // when
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Client> clients = entityManager.createQuery("FROM clients c", Client.class).getResultList();
        entityManager.getTransaction().commit();

        // then
        assertEquals(CLIENTS_NUMBER, clients.size(), "Clients number is not equal");
    }

    @Test
    void given_whenSelect_then() {
        // given
        // NOTE: entityManagerFactory initialized in setUp() method...

        // when
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<String> labels = entityManager.createQuery("SELECT c.label FROM clients c", String.class)
                .setMaxResults(3)
                .getResultList();
        entityManager.getTransaction().commit();

        // then
        assertEquals(CLIENT_LABELS, labels.size(), "Client labels are not equal");
    }

    @Test
    void given_whenFromWhere_then() {
        // given
        // NOTE: entityManagerFactory initialized in setUp() method...

        // when
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Client> clients = entityManager.createQuery("FROM clients c " +
                "WHERE c.label = '" + CLIENT_LABEL_DRIVER + "'", Client.class)
                .getResultList();
        entityManager.getTransaction().commit();

        // then
        assertEquals(CLIENT_DRIVER_LABELS, clients.size(), "Clients number is not equal");
    }

    @Test
    void given_whenSelectOrderBy_then() {
        // given
        // NOTE: entityManagerFactory initialized in setUp() method...

        // when
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Client> clients = entityManager.createQuery("SELECT c FROM clients c " +
                "ORDER BY c.age DESC", Client.class)
                .getResultList();
        entityManager.getTransaction().commit();

        // then
        assertEquals(CLIENTS_NUMBER, clients.size(), "Clients number is not equal");
    }

    @Test
    void given_whenSelectGroupBy_then() {
        // given
        // NOTE: entityManagerFactory initialized in setUp() method...

        // when
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Object> avgAge = entityManager.createQuery("SELECT AVG(c.age) FROM clients c " +
                "GROUP BY c.label", Object.class)
                .getResultList();
        entityManager.getTransaction().commit();

        // then
        assertEquals(CLIENT_LABELS, avgAge.size(), "Clients number is not equal");
    }

    @Test
    void given_whenSelectFromJoin_then() {
        // given
        // NOTE: entityManagerFactory initialized in setUp() method...

        // when
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Client> clients = entityManager.createQuery("SELECT c FROM clients c " +
                "LEFT JOIN c.orders AS o " +
                "WITH c.label = '" + CLIENT_LABEL_OFFICE_WORKER + "' " +
                "WHERE o.amount > 5", Client.class)
                .getResultList();
        System.out.println(clients);
        entityManager.getTransaction().commit();

        // then
        assertEquals(CLIENTS_JOIN_ORDER_NUMBER, clients.size(), "Clients number is not equal");
    }
}
