package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;

import javax.swing.*;
import java.awt.*;

// Has all the create-read-update-delete options
abstract class TablePanelCRUD extends TablePanelAddDelete {
    TablePanelCRUD(QueryController queryController, DatabaseUpdater databaseUpdater) {
        super(queryController, databaseUpdater);
        JButton editButton = new JButton("Редактировать");
        GridBagConstraints editButtonConstraints = new GridBagConstraints();
        editButtonConstraints.weightx = 1;
        editButtonConstraints.weighty = 1;
        setEditButtonCoordinates(editButtonConstraints);
        add(editButton, editButtonConstraints);
    }

    void setEditButtonCoordinates(GridBagConstraints editButtonConstraints) {
        editButtonConstraints.gridx = 1;
        editButtonConstraints.gridy = 1;
    }

//    This is a bit awkward, because I have to write the whole thing and not just
//    the coordinates, but it's good enough. Yeah, this should be fixed when refactoring
//    to improve code quality, if nothing else
    @Override
    void setDeleteButtonConstraints(GridBagConstraints deleteButtonConstraints) {
        deleteButtonConstraints.gridx = 2;
        deleteButtonConstraints.gridy = 1;
    }
}
