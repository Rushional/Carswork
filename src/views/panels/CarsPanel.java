package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;
import views.dialogs.CarData;
import views.dialogs.DialogAddCar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsPanel extends TablePanelAddDelete {
    public CarsPanel(QueryController queryController, DatabaseUpdater databaseUpdater, JFrame parentFrame) {
        super(queryController, databaseUpdater, parentFrame);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseUpdater.addCar(getAddedData());
                replaceTable();
            }
        });
    }

    private CarData getAddedData() {
        var dialog = new DialogAddCar(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getCarData();
    }

    @Override
    void updateCurrentIdentifier() {
        currentId = currentJTable.getValueAt(currentJTable.getSelectedRow(), 2).toString();
    }

    @Override
    String getTableDatabaseName() {
        return "car";
    }

    @Override
    String getIdentifierColumnName() {
        return "license_plate";
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.CARS;
    }
}
