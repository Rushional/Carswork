package interface_interaction;

import queries.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateComboListenerDate implements ActionListener {
    private LegacyQueryManager legacyQueryManager;

    public WorkerProblemsByDateComboListenerDate(LegacyQueryManager legacyQueryManager) {
        this.legacyQueryManager = legacyQueryManager;
    }

    public void actionPerformed(ActionEvent e) {
        WorkerProblemsByDateComboBoxDate workerProblemsByDateComboBoxDate = (WorkerProblemsByDateComboBoxDate)e.getSource();
        String timePeriod = (String)workerProblemsByDateComboBoxDate.getSelectedItem();
        legacyQueryManager.setQueryTimePeriod(timePeriod);
    }
}
