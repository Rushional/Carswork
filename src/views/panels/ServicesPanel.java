package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;
import views.dialogs.DialogEditServices;

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
    }

    double getEditedServicePrice() {
        var dialog = new DialogEditServices(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getRentCost();
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
