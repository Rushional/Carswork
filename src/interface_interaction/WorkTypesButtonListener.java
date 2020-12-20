package interface_interaction;

import graphics.ResultsDisplayer;
import queries.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkTypesButtonListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private ResultsDisplayer resultsDisplayer;

    public WorkTypesButtonListener(LegacyQueryManager legacyQueryManager, ResultsDisplayer resultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        resultsDisplayer.displayWorkTypes(legacyQueryManager.workTypes());
    }
}
