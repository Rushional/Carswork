package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;
import views.dialogs.DialogEditWorkers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkersPanel extends TablePanelCRUD {
    public WorkersPanel(QueryController queryController, DatabaseUpdater databaseUpdater, JFrame parentFrame) {
        super(queryController, databaseUpdater, parentFrame);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseUpdater.updateWorker(currentId, getEditedPhoneNumber());
                replaceTable();
            }
        });
    }

    String getEditedPhoneNumber() {
        DialogEditWorkers dialog = new DialogEditWorkers(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getPhoneNumber();
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.WORKERS;
    }

    @Override
    String getTableDatabaseName() {
        return "worker";
    }

    @Override
    String getIdentifierColumnName() {
        return "worker_name";
    }
}
