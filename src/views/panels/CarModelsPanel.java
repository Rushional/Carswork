package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;
import views.dialogs.*;

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
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseUpdater.addCarModel(getAddedData());
                replaceTable();
            }
        });
    }

    private double getEditedRentCost() {
        var dialog = new DialogEditCarModel(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getRentCost();
    }

    private CarModelData getAddedData() {
        var dialog = new DialogAddCarModel(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getCarModelData();
    }

    @Override
    void addDeleteButtonListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentId == null) {
                    System.out.println("Ну чего ты преколы показываешь");
                }
                else {
                    databaseUpdater.deleteEntry(
                            "owned_model_data", "fk_model_name", currentId
                    );
                    databaseUpdater.deleteEntry(
                            getTableDatabaseName(), getIdentifierColumnName(), currentId
                    );
                    replaceTable();
                }
            }
        });
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
