package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class TablePanelAddDelete extends TablePanel {
    String currentId = null;
    JFrame parentFrame;
    JButton addButton;
    JButton deleteButton;
    DatabaseUpdater databaseUpdater;

    TablePanelAddDelete(QueryController queryController, DatabaseUpdater databaseUpdater, JFrame parentFrame) {
        super(queryController);
        this.databaseUpdater = databaseUpdater;
        this.parentFrame = parentFrame;
        addButton = new JButton("Добавить");
        GridBagConstraints addButtonConstraints = new GridBagConstraints();
        addButtonConstraints.weightx = 1;
        addButtonConstraints.weighty = 1;
        setAddButtonCoordinates(addButtonConstraints);
        add(addButton, addButtonConstraints);

        deleteButton = new JButton("Удалить");
        GridBagConstraints deleteButtonConstraints = new GridBagConstraints();
        deleteButtonConstraints.weightx = 1;
        deleteButtonConstraints.weighty = 1;
        setDeleteButtonConstraints(deleteButtonConstraints);
        add(deleteButton, deleteButtonConstraints);
        addDeleteButtonListener();

        addTableListener();
    }

    private void addTableListener() {
        currentJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                updateCurrentIdentifier();
            }
        });
    }

    void updateCurrentIdentifier() {
        currentId = currentJTable.getValueAt(currentJTable.getSelectedRow(), 0).toString();
    }

    void addDeleteButtonListener() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentId == null) {
                    System.out.println("Ну чего ты преколы показываешь");
                }
                else {
                    databaseUpdater.deleteEntry(
                            getTableDatabaseName(), getIdentifierColumnName(), currentId
                    );
                    replaceTable();
                }
            }
        });
    }

    void setAddButtonCoordinates(GridBagConstraints addButtonConstraints) {
        addButtonConstraints.gridx = 0;
        addButtonConstraints.gridy = 1;
    }

    void setDeleteButtonConstraints(GridBagConstraints deleteButtonConstraints) {
        deleteButtonConstraints.gridx = 1;
        deleteButtonConstraints.gridy = 1;
    }

//    This links View and database, and should be fixed
//    But I'm kinda dying right now so it will have to do
//    Yes, this should be refactored to, but uhhhh it's good enough
//    Also, I could AT LEAST store these values together in one object,
//    but even that is too much for me right now
//    I see this stuff, I want to improve it, but I have to go on and ship this whole thing in time
//    Something something budget cuts!
    abstract String getTableDatabaseName();

    abstract String getIdentifierColumnName();
}
