package views;

import org.hibernate.Session;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Initiator {
    private MainFrame frame;


    public Initiator() {
    }

    public void initiateInterface(Session session) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                frame = new MainFrame(session);
                frame.pack();
                frame.setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
    }

    public MainFrame getFrame() {
        return frame;
    }
}
