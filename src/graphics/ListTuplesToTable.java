package graphics;

import queries.TableData;

import javax.persistence.Tuple;
import javax.persistence.TupleElement;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListTuplesToTable {
    public static JTable call(TableData tableData) {
        List<Tuple> listTuples = tableData.getTuplesList();
        String[] columnNames = tableData.getColumnNames();
        ArrayList<Object[]> table = new ArrayList<Object[]>();
        for (Tuple tuple : listTuples) {
            Object[] tableRow = tuple.toArray();
            table.add(tableRow);
        }
        Object[][] dataForJTable = new Object[table.size()][getColumnAmount(listTuples)];
        table.toArray(dataForJTable);
//        Get columnNames from Tuple.getElements() and for each one .getAlias() in cycle
        return new JTable(dataForJTable, columnNames);
    }

    private static int getColumnAmount(List<Tuple> listTuples) {
        Tuple tableDataTuple = listTuples.get(0);
        List<TupleElement<?>> tupleElementList = tableDataTuple.getElements();
        return tupleElementList.size();
    }
}
