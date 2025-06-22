package se.rich.grtiming2.system;

import org.junit.Test;
import se.rich.grtiming2.system.manager.UserManager;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserTest {
    private static final Logger logger = Logger.getLogger(UserTest.class.getName());
    private final UserManager userManager = new UserManager();
    User user = new User();

    @Test
    public void testUser() {
        try {
            user.setAge(42);

            user.setFirstName("John");
            user.setGender("Male");

            /*userManager.getSession().beginTransaction();
            userManager.getSession().persist(user);
            userManager.getSession().getTransaction().commit();*/

            List<User> userList = userManager.getEntityManager().createQuery("select u from User u", User.class).getResultList();

            userList.forEach(System.out::println);

            assertEquals(user.getFirstName(), userList.getFirst().getFirstName());

            userManager.tearDown();
        } catch (Exception e) {
            logger.log(Level.SEVERE, String.valueOf(e));
            e.printStackTrace();
        }
    }
}
