package interface_interaction;

import graphics.ResultsDisplayer;
import queries.QueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsClientsButtonListener implements ActionListener {
    private QueryManager queryManager;
    private ResultsDisplayer resultsDisplayer;

    public CarsClientsButtonListener(QueryManager queryManager, ResultsDisplayer resultsDisplayer) {
        this.queryManager = queryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        resultsDisplayer.displayCarsClients(queryManager.carsClients());
    }
}
