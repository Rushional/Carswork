package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;
import views.dialogs.DialogAddWorker;
import views.dialogs.DialogEditWorker;
import views.dialogs.WorkerData;

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
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseUpdater.addWorker(getAddedData());
                replaceTable();
            }
        });
    }

    private String getEditedPhoneNumber() {
        var dialog = new DialogEditWorker(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getPhoneNumber();
    }

    private WorkerData getAddedData() {
        var dialog = new DialogAddWorker(parentFrame);
        dialog.pack();
        dialog.setVisible(true);
        return dialog.getWorkerData();
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
