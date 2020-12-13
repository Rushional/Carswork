package views;

import graphics.ListTuplesToTable;
import org.hibernate.Session;
import queries.GetQueryData;
import queries.QueryController;
import queries.TableData;

import javax.swing.*;
import java.awt.*;

public class CarModelsPanel extends JPanel {
    public CarModelsPanel(Session session) {
        setBackground(new Color(235, 240, 255));
        setPreferredSize(new Dimension(700, 300));
        setLayout(new GridBagLayout());
        QueryController queryController = new QueryController(session);
        TableData carTableData = queryController.getTableData(GetQueryData.selectCars());
        JTable carTable = ListTuplesToTable.call(carTableData);

        JScrollPane scrollPane = new JScrollPane(carTable);
        carTable.setFillsViewportHeight(true);
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
}
