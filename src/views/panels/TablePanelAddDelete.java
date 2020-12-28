package views.panels;

import controllers.QueryController;

import javax.swing.*;
import java.awt.*;

// This class is basically all the tables except recommendations panel
public abstract class TablePanelAddDelete extends TablePanel {
    public TablePanelAddDelete(QueryController queryController) {
        super(queryController);
        JButton addButton = new JButton("Добавить");
        GridBagConstraints addButtonConstraints = new GridBagConstraints();
        addButtonConstraints.weightx = 1;
        addButtonConstraints.weighty = 1;
        setAddButtonCoordinates(addButtonConstraints);
        add(addButton, addButtonConstraints);

        JButton deleteButton = new JButton("Удалить");
        GridBagConstraints deleteButtonConstraints = new GridBagConstraints();
        deleteButtonConstraints.weightx = 1;
        deleteButtonConstraints.weighty = 1;
        setDeleteButtonConstraints(deleteButtonConstraints);
        add(deleteButton, deleteButtonConstraints);
    }

    void setAddButtonCoordinates(GridBagConstraints addButtonConstraints) {
        addButtonConstraints.gridx = 0;
        addButtonConstraints.gridy = 1;
    }

    void setDeleteButtonConstraints(GridBagConstraints deleteButtonConstraints) {
        deleteButtonConstraints.gridx = 1;
        deleteButtonConstraints.gridy = 1;
    }

}
