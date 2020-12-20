package interface_interaction;

import graphics.ResultsDisplayer;
import queries.LegacyQueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarWorksComboListener implements ActionListener {
    private LegacyQueryManager legacyQueryManager;
    private ResultsDisplayer resultsDisplayer;

    public CarWorksComboListener(LegacyQueryManager legacyQueryManager, ResultsDisplayer resultsDisplayer) {
        this.legacyQueryManager = legacyQueryManager;
        this.resultsDisplayer = resultsDisplayer;
    }

    public void actionPerformed(ActionEvent e) {
        CarWorksComboBox carWorksComboBox = (CarWorksComboBox)e.getSource();
//        int carId = Integer.parseInt((String)carWorksComboBox.getSelectedItem());
        int index = carWorksComboBox.getSelectedIndex();
        int carId = (int) legacyQueryManager.getCarNames().get(index).get("id");
        resultsDisplayer.displayCarWorks(legacyQueryManager.carWorks(carId), (String)carWorksComboBox.getSelectedItem());
    }
}
