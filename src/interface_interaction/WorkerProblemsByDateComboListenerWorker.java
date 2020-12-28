package interface_interaction;

import models.database_interaction.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateComboListenerWorker implements ActionListener {
    private LegacyQueryManager legacyQueryManager;

    public WorkerProblemsByDateComboListenerWorker(LegacyQueryManager legacyQueryManager) {
        this.legacyQueryManager = legacyQueryManager;
    }

    public void actionPerformed(ActionEvent e) {
        WorkerProblemsByDateComboBoxWorker workerProblemsByDateComboBoxWorker = (WorkerProblemsByDateComboBoxWorker) e.getSource();
        int index = workerProblemsByDateComboBoxWorker.getSelectedIndex();
        int workerId = (int) legacyQueryManager.getWorkerNames().get(index).get("id");
        legacyQueryManager.setWorkerId(workerId);
        legacyQueryManager.setWorkerName((String)workerProblemsByDateComboBoxWorker.getSelectedItem());
    }
}
