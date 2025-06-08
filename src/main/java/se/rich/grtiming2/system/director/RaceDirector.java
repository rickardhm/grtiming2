package se.rich.grtiming2.system.director;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import se.rich.grtiming2.system.director.Director;

public abstract class RaceDirector implements Director {
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public void setUp() {
        final StandardServiceRegistry registryBuilder = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registryBuilder).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
        }
        catch (Exception e) {
            sessionFactory.close();
        }
    }

    @Override
    public void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public Transaction getTransaction() {
        if (null == session) {
            setUp();
        }
        return session.beginTransaction();
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public Session getSession() {
        return session;
    }
}
