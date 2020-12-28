package views;

import models.database_interaction.SessionCreator;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

// Could be a singleton
public class Initiator {
    private Frame frame;


    public Initiator() {
    }

    public void initiateInterface(SessionCreator sessionCreator) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                frame = new Frame(sessionCreator);
                frame.pack();
                frame.setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
    }

    public Frame getFrame() {
        return frame;
    }
}
