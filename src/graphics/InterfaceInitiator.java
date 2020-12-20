package graphics;

import org.hibernate.Session;
import queries.LegacyQueryManager;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class InterfaceInitiator {
    private LegacyQueryManager legacyQueryManager;
    private ResultsDisplayer resultsDisplayer;
    private Frame frame;


    public InterfaceInitiator(Session session) {
        legacyQueryManager = new LegacyQueryManager(session);
        resultsDisplayer = new ResultsDisplayer();
    }

    public void initiateInterface() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    frame = new Frame(legacyQueryManager, resultsDisplayer);
                    frame.pack();
                    frame.setVisible(true);
                }
            });
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace(System.out);
        }
        resultsDisplayer.setInterface(frame, legacyQueryManager);
    }

    public Frame getFrame() {
        return frame;
    }

    public LegacyQueryManager getLegacyQueryManager() {
        return legacyQueryManager;
    }
}
