package se.rich.grtiming2.system;

import org.junit.Test;
import se.rich.grtiming2.system.manager.ParticipantManager;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ParticipantTest {
    private ParticipantManager participantManager = new ParticipantManager();

    @Test
    public void testParticipant() {
        try {
            //List<Participant> participantList = participantManager.getSession().createQuery("select p from Participant p", Participant.class).list();
            List<Participant> participantList = participantManager.getEntityManager().createQuery("select p from Participant p", Participant.class).getResultList();
            participantManager.tearDown();
        } catch (Exception e) {
            participantManager.tearDown();
            e.printStackTrace();
        }
    }
}
