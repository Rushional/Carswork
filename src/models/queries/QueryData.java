package models.queries;

public class QueryData {
    private String[] columnNames;
    private String query;

    QueryData(String[] columnNames, String query) {
        this.columnNames = columnNames;
        this.query = query;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public String getQuery() {
        return query;
    }
}
