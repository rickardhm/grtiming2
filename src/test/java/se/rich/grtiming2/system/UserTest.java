package se.rich.grtiming2.system;

import org.junit.Test;
import se.rich.grtiming2.system.manager.UserManager;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserTest {
    private static final Logger logger = Logger.getLogger(UserTest.class.getName());
    private final UserManager userManager = new UserManager();

    @Test
    public void testUser() {
        User user = new User();
        user.setAge(42);
        user.setFirstName("Jim");
        user.setGender("doe");

        Address address = new Address();
        address.setCity("staden");
        address.setPostcode("42");
        address.setStreetAddress("gatan 1");

        user.getAddresses().add(address);
        address.getUsers().add(user);

        try {
            userManager.getEntityManager().getTransaction().begin();
            userManager.getEntityManager().persist(user);
            userManager.getEntityManager().persist(address);
            userManager.getEntityManager().getTransaction().commit();

            List<User> userList = userManager.getEntityManager().createQuery("select u from User u", User.class)
                    .getResultList();

            userList.forEach(System.out::println);

            assertEquals(user.getFirstName(), userList.getFirst().getFirstName());

            userManager.tearDown();
        } catch (Exception e) {
            logger.log(Level.SEVERE, String.valueOf(e));
            e.printStackTrace();
        }
    }
}
