package views.panels;

import queries.QueryController;
import queries.QueryData;
import queries.TableData;
import services.TableDataToJTable;

import javax.swing.*;
import java.awt.*;

public abstract class TablePanel extends JPanel {
    private JTable currentJTable = null;
    private QueryController queryController;
    private boolean readOnly;

    public TablePanel(QueryController queryController, boolean readOnly) {
        this.queryController = queryController;
        this.readOnly = readOnly;
        setBackground(new Color(235, 240, 255));
//        setPreferredSize(new Dimension(500, 120));
        setPreferredSize(new Dimension(700, 300));
        setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(getJTable());
        scrollPane.setPreferredSize(new Dimension(500, 200));
        GridBagConstraints scrollPaneConstraints = new GridBagConstraints();
        scrollPaneConstraints.weightx = 1;
        scrollPaneConstraints.weighty = 1;
        scrollPaneConstraints.gridx = 0;
        scrollPaneConstraints.gridy = 0;
        scrollPaneConstraints.anchor = GridBagConstraints.PAGE_START;
        scrollPaneConstraints.insets = new Insets(10, 0, 0, 0);
        scrollPaneConstraints.gridwidth = 3;
        add(scrollPane, scrollPaneConstraints);

        if (!this.readOnly) {
            JButton deleteButton = new JButton("Удалить");
            GridBagConstraints deleteButtonConstraints = new GridBagConstraints();
            deleteButtonConstraints.weightx = 1;
            deleteButtonConstraints.weighty = 1;
            deleteButtonConstraints.gridx = 0;
            deleteButtonConstraints.gridy = 1;
            add(deleteButton, deleteButtonConstraints);

            JButton editButton = new JButton("Редактировать");
            GridBagConstraints editButtonConstraints = new GridBagConstraints();
            editButtonConstraints.weightx = 1;
            editButtonConstraints.weighty = 1;
            editButtonConstraints.gridx = 1;
            editButtonConstraints.gridy = 1;
            add(editButton, editButtonConstraints);

            JButton addButton = new JButton("Добавить");
            GridBagConstraints addButtonConstraints = new GridBagConstraints();
            addButtonConstraints.weightx = 1;
            addButtonConstraints.weighty = 1;
            addButtonConstraints.gridx = 2;
            addButtonConstraints.gridy = 1;
            add(addButton, addButtonConstraints);
        }
//        replaceTable();
    }

//    This method removes the current shown panel and immediately starts displaying another one
    void replaceTable() {
//        start showing it!
//        That's probably redrawing it or something. Maybe call revalidate or some king of repaint or whatever?..
//        I don't remember! Yay!
    }

//    calls MakeQuery with the right parameters (taken from QueriesData) and so gets the needed table
//    that will be used in replaceTable
    private JTable getJTable() {
        TableData tableData = queryController.getTableData(getQueryData());
        return TableDataToJTable.call(tableData);
    }

    /**
     * Gets a correct QueryData object from QueriesData
     * @return the data needed to make a JTable to output on the panel
     */
    abstract QueryData getQueryData();
}
