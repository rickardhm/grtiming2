package se.rich.grtiming2.system;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.rich.grtiming2.system.manager.AddressManager;

import java.util.List;

import static org.junit.Assert.*;

public class AddressTest {

    private final AddressManager addressManager = new AddressManager();
    @Test
    public void testAddress() {
    try {
        List<Address> addressList = addressManager.getSession().createQuery("select a from Address a", Address.class).list();
        assertNotNull(addressList);
        addressManager.tearDown();
    } catch (Exception e) {
        addressManager.tearDown();
        e.printStackTrace();
    }
    }

}