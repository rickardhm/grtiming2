package se.rich.grtiming2.system.director;

import org.hibernate.Session;
import org.hibernate.Transaction;

public interface Director {
    public void setUp();
    public void tearDown();
    public Transaction getTransaction();
    public Session getSession();
}
