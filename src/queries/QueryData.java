package queries;

public class QueryData {
    private String[] columnNames;
    private String query;

    public QueryData(String[] columnNames, String query) {
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
