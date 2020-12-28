package interface_interaction;

import graphics.LegacyResultsDisplayer;
import models.database_interaction.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientCostComboListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private LegacyResultsDisplayer legacyResultsDisplayer;

    public ClientCostComboListener(LegacyQueryManager legacyQueryManager, LegacyResultsDisplayer legacyResultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.legacyResultsDisplayer = legacyResultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        ClientCostComboBox clientCostComboBox = (ClientCostComboBox)e.getSource();
        int index = clientCostComboBox.getSelectedIndex();
        int clientId = (int) legacyQueryManager.getClientNames().get(index).get("id");
        legacyResultsDisplayer.displayClientCost(legacyQueryManager.clientCost(clientId), (String)clientCostComboBox.getSelectedItem());
    }
}
