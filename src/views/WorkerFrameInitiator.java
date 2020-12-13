package views;

import org.hibernate.Session;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class WorkerFrameInitiator {
    private WorkerFrame frame;


    public WorkerFrameInitiator() {
    }

    public void initiateInterface(Session session) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                frame = new WorkerFrame(session);
                frame.pack();
                frame.setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
    }

    public WorkerFrame getFrame() {
        return frame;
    }
}
