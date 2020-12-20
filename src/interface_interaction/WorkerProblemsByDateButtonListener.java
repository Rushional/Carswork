package interface_interaction;

import graphics.ResultsDisplayer;
import queries.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateButtonListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private ResultsDisplayer resultsDisplayer;

    public WorkerProblemsByDateButtonListener(LegacyQueryManager legacyQueryManager, ResultsDisplayer resultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        if (legacyQueryManager.getQueryTimePeriod() != null && legacyQueryManager.getWorkerId() != -1) {
            resultsDisplayer.displayWorkerProblemsByDate(legacyQueryManager.workerProblemsByDate(), legacyQueryManager.getWorkerName());
        }
    }
}
