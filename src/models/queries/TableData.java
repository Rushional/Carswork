package models.queries;

import javax.persistence.Tuple;
import java.util.List;

public class TableData {
    private List<Tuple> tuplesList;
    private String[] columnNames;

    public TableData(List<Tuple> tuplesList, String[] columnNames) {
        this.tuplesList = tuplesList;
        this.columnNames = columnNames;
    }

    public List<Tuple> getTuplesList() {
        return tuplesList;
    }

    public String[] getColumnNames() {
        return columnNames;
    }
}
