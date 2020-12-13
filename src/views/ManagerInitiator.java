package views;

import org.hibernate.Session;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class ManagerInitiator {
    private ManagerFrame frame;


    public ManagerInitiator() {
    }

    public void initiateInterface(Session session) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                frame = new ManagerFrame(session);
                frame.pack();
                frame.setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
    }
}
