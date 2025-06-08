package se.rich.grtiming2.system;

import org.junit.Test;
import se.rich.grtiming2.system.manager.RaceManager;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class RaceTest {

    private final RaceManager raceManager = new RaceManager();
    @Test
    public void getUser() {
        try {
            List<Race> raceList = raceManager.getSession().createQuery("select r from Race r", Race.class).list();
            assertNotNull(raceList);
            raceManager.tearDown();
        } catch (Exception e) {
            raceManager.tearDown();
            e.printStackTrace();
        }
    }

}