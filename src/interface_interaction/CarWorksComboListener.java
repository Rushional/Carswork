package interface_interaction;

import graphics.LegacyResultsDisplayer;
import models.database_interaction.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarWorksComboListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private LegacyResultsDisplayer legacyResultsDisplayer;

    public CarWorksComboListener(LegacyQueryManager legacyQueryManager, LegacyResultsDisplayer legacyResultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.legacyResultsDisplayer = legacyResultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        CarWorksComboBox carWorksComboBox = (CarWorksComboBox)e.getSource();
//        int carId = Integer.parseInt((String)carWorksComboBox.getSelectedItem());
        int index = carWorksComboBox.getSelectedIndex();
        int carId = (int) legacyQueryManager.getCarNames().get(index).get("id");
        legacyResultsDisplayer.displayCarWorks(legacyQueryManager.carWorks(carId), (String)carWorksComboBox.getSelectedItem());
    }
}
