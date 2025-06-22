package se.rich.grtiming2.system.director;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class JpaRaceDirector {
    private EntityManagerFactory entityManagerFactory;
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @BeforeEach
    public void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            entityManagerFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    @AfterEach
    public void tearDown() {
        if(null != entityManagerFactory) {
            entityManagerFactory.close();
        }
    }
}
