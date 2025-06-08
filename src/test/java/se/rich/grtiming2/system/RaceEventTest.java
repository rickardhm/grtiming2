package se.rich.grtiming2.system;

import org.junit.Test;
import se.rich.grtiming2.system.manager.RaceEventManager;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class RaceEventTest {
    private final RaceEventManager raceEventManager = new RaceEventManager();
    @Test
    public void getRaceEvent() {
        try {
            List<RaceEvent> raceEventList = raceEventManager.getSession().createQuery("select re from RaceEvent re", RaceEvent.class).list();
            assertNotNull(raceEventList);
            raceEventManager.tearDown();
        } catch (Exception e) {
            raceEventManager.tearDown();
            e.printStackTrace();
        }
    }
}
