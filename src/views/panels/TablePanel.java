package views.panels;

import controllers.QueryController;
import models.queries.SelectQueries;
import models.queries.TableData;
import services.ConvertTableDataToJTable;

import javax.swing.*;
import java.awt.*;


// TODO: shouldn't access the queryController. Should instead have something a bit smaller
// or idk, this architecture is kinda weird?..
// It works, so I'm probably going to ship it as is
// But yeah, this should probably be improved
    abstract class TablePanel extends JPanel {
    JTable currentJTable = null;
//    I could remove either scrollPane or the table, but it's a bit more comfortable this way
    private JScrollPane scrollPane = null;
    private QueryController queryController;
//    Kinda awkward, because we store data that will only be needed for TablePanelAddDelete,
//    but it's easier this way, because the table is created here. We'd have to store something
//    no matter what, I think. So it's okay actually

    TablePanel(QueryController queryController) {
        this.queryController = queryController;

        setBackground(new Color(235, 240, 255));
//        setPreferredSize(new Dimension(500, 120));
        setPreferredSize(new Dimension(700, 300));
        setLayout(new GridBagLayout());

        currentJTable = getJTable();
        scrollPane = new JScrollPane(currentJTable);
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
//        replaceTable();
    }

//    start showing updated table
    void replaceTable() {
        currentJTable = getJTable();
        scrollPane.setViewportView(currentJTable);
    }

//    calls MakeQuery with the right parameters (taken from QueriesData) and so gets the needed table
//    that will be used in replaceTable
    private JTable getJTable() {
        TableData tableData = queryController.getTableData(getQueryEnum());
        return ConvertTableDataToJTable.call(tableData);
    }

    /**
     * Gets a correct SelectQueries enum that will be used to make a correct fetch query5
     * @return the data needed to make a JTable to output on the panel
     */
    abstract SelectQueries getQueryEnum();
}
