package controllers;

import org.hibernate.Session;
import queries.*;

import javax.persistence.Tuple;
import java.util.List;

public class QueryController {
    private Session session;

    public QueryController(Session session) {
        this.session = session;
    }

    public TableData getTableData(SelectQueries queryEnum) {
        QueryData queryData = getQueryDataFromEnum(queryEnum);
        return new TableData(MakeQuery.call(session, queryData.getQuery()), queryData.getColumnNames());
    }

//    My queries storage and usage is a bit awkward, but I love it dearly
//    (and I have to do other stuff:c)
    public List<Tuple> getParameterTable(SelectQueries queryEnum, String parameterName) {
        QueryData queryData = getQueryDataFromEnum(queryEnum, parameterName);
        return MakeQuery.call(session, queryData.getQuery());
    }

    private QueryData getQueryDataFromEnum(SelectQueries queryEnum) {
        switch (queryEnum) {
            case CARS:
                return QueriesData.cars();
            case ORDERS:
                return QueriesData.orders();
            case WORKERS:
                return QueriesData.workers();
            case SERVICES:
                return QueriesData.services();
            case OWNED_MODELS:
                return QueriesData.ownedModels();
            case PARAMETERS_OUTPUT:
                return QueriesData.parametersOutput();
            case PARAMETERS_LIST:
                return QueriesData.parametersList();
            case POTENTIAL_MODELS:
                return QueriesData.potentialModels();
            default:
//                This only happens if you try to get data for the correlation calculation
//                and do not specify a parameter. I kinda feel like this is a bad idea,
//                because it gives the programmer an opportunity to mess things up and
//                forces them to remember stuff. But I'm leaving it as it is. Good enough I guess
                throw new RuntimeException("Женя, ну ты чё натворил блин блин");
        }
    }

    private QueryData getQueryDataFromEnum(SelectQueries queryEnum, String parameterName) {
        switch (queryEnum) {
            case NUMERICAL:
                return QueriesData.numerical(parameterName);
            case QUALITATIVE:
                return QueriesData.qualitative(parameterName);
            default:
                return getQueryDataFromEnum(queryEnum);
        }
    }

    public void sendUpdateQuery() {

    }
}
