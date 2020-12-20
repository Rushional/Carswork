package interface_interaction;

import graphics.ResultsDisplayer;
import queries.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientCostComboListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private ResultsDisplayer resultsDisplayer;

    public ClientCostComboListener(LegacyQueryManager legacyQueryManager, ResultsDisplayer resultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        ClientCostComboBox clientCostComboBox = (ClientCostComboBox)e.getSource();
        int index = clientCostComboBox.getSelectedIndex();
        int clientId = (int) legacyQueryManager.getClientNames().get(index).get("id");
        resultsDisplayer.displayClientCost(legacyQueryManager.clientCost(clientId), (String)clientCostComboBox.getSelectedItem());
    }
}
