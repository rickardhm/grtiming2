package se.rich.grtiming2.system;

import org.junit.Test;
import se.rich.grtiming2.system.manager.UserManager;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class UserTest {
    private final UserManager userManager = new UserManager();

    @Test
    public void testUser() {
        try {
            List<User> userList = userManager.getSession().createQuery("select u from User u", User.class).list();
            assertNotNull(userList);
            System.out.println(userList);
            userManager.tearDown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
