package services;

import models.queries.TableData;

import javax.persistence.Tuple;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertTableDataToJTable {
    public static JTable call(TableData tableData) {
        List<Tuple> listTuples = tableData.getTuplesList();
        String[] columnNames = tableData.getColumnNames();
        ArrayList<Object[]> table = new ArrayList<Object[]>();
        for (Tuple tuple : listTuples) {
            Object[] tableRow = tuple.toArray();
            table.add(tableRow);
        }
//        Tuple's way of getting columns amount is awkward, so I'm using the columnNames
//        They're all constants and it's fine
        Object[][] dataForJTable = new Object[table.size()][columnNames.length];
        table.toArray(dataForJTable);
//        Get columnNames from Tuple.getElements() and for each one .getAlias() in cycle
        JTable outputTable = new JTable(dataForJTable, columnNames);
        outputTable.setFillsViewportHeight(true);
        return outputTable;
    }
}
