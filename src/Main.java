import models.database_interaction.SessionCreator;
import org.hibernate.Session;
import views.Initiator;

public class Main {
    public static void main(final String[] args) throws Exception {
        SessionCreator sessionCreator = new SessionCreator();
        final Session session = sessionCreator.getSession();
        try {
            Initiator initiator = new Initiator();
            initiator.initiateInterface(sessionCreator);
        } finally {
            session.close();
        }
    }
}