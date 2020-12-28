package interface_interaction;

import graphics.LegacyResultsDisplayer;
import models.database_interaction.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateButtonListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private LegacyResultsDisplayer legacyResultsDisplayer;

    public WorkerProblemsByDateButtonListener(LegacyQueryManager legacyQueryManager, LegacyResultsDisplayer legacyResultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.legacyResultsDisplayer = legacyResultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        if (legacyQueryManager.getQueryTimePeriod() != null && legacyQueryManager.getWorkerId() != -1) {
            legacyResultsDisplayer.displayWorkerProblemsByDate(legacyQueryManager.workerProblemsByDate(), legacyQueryManager.getWorkerName());
        }
    }
}
