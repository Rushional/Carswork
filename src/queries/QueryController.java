package queries;

import org.hibernate.Session;

public class QueryController {
    private Session session;

    public QueryController(Session session) {
        this.session = session;
    }

    public TableData getTableData(QueryData queryData) {
        return new TableData(MakeQuery.call(session, queryData.getQuery()), queryData.getColumnNames());
    }
}
