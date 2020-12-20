package interface_interaction;

import graphics.ResultsDisplayer;
import queries.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsClientsButtonListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private ResultsDisplayer resultsDisplayer;

    public CarsClientsButtonListener(LegacyQueryManager legacyQueryManager, ResultsDisplayer resultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        resultsDisplayer.displayCarsClients(legacyQueryManager.carsClients());
    }
}
