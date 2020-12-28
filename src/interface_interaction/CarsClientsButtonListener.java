package interface_interaction;

import graphics.LegacyResultsDisplayer;
import models.database_interaction.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsClientsButtonListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private LegacyResultsDisplayer legacyResultsDisplayer;

    public CarsClientsButtonListener(LegacyQueryManager legacyQueryManager, LegacyResultsDisplayer legacyResultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.legacyResultsDisplayer = legacyResultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        legacyResultsDisplayer.displayCarsClients(legacyQueryManager.carsClients());
    }
}
