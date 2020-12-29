package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;
import views.dialogs.DialogEditCarModels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarModelsPanel extends TablePanelCRUD {
    public CarModelsPanel(QueryController queryController, DatabaseUpdater databaseUpdater, JFrame parentFrame) {
        super(queryController, databaseUpdater, parentFrame);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseUpdater.updateCarModels(currentId, getEditedRentCost());
                replaceTable();
            }
        });
    }

    double getEditedRentCost() {
        var dialog = new DialogEditCarModels(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getRentCost();
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.OWNED_MODELS;
    }

    @Override
    String getTableDatabaseName() {
        return "car_model";
    }

    @Override
    String getIdentifierColumnName() {
        return "model_name";
    }
}
