import models.database_interaction.SessionCreator;
import org.hibernate.Session;
import views.Initiator;
import views.dialogs.DialogAddWorker;

public class Main {
    public static void main(final String[] args) throws Exception {
        SessionCreator sessionCreator = new SessionCreator();
        final Session session = sessionCreator.getSession();
        try {
            Initiator initiator = new Initiator();
            initiator.initiateInterface(sessionCreator);
//            I was testing how the dialog looks, and might again with another one
//            var dialog = new DialogAddWorker(initiator.getFrame());
//            dialog.pack();
//            dialog.setVisible(true);
        } finally {
            session.close();
        }
    }
}