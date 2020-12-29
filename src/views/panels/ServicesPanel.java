package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;
import views.dialogs.DialogAddService;
import views.dialogs.DialogEditService;
import views.dialogs.ServiceData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicesPanel extends TablePanelCRUD {
    public ServicesPanel(QueryController queryController, DatabaseUpdater databaseUpdater, JFrame parentFrame) {
        super(queryController, databaseUpdater, parentFrame);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseUpdater.updateServices(currentId, getEditedServicePrice());
                replaceTable();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseUpdater.addService(getAddedData());
                replaceTable();
            }
        });
    }

    private double getEditedServicePrice() {
        var dialog = new DialogEditService(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getRentCost();
    }

    private ServiceData getAddedData() {
        var dialog = new DialogAddService(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getServiceData();
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.SERVICES;
    }

    @Override
    String getTableDatabaseName() {
        return "work_type";
    }

    @Override
    String getIdentifierColumnName() {
        return "work_type_name";
    }
}
