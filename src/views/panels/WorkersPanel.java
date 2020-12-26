package views.panels;

import queries.QueriesData;
import queries.QueryController;
import queries.QueryData;

public class WorkersPanel extends TablePanel {
    public WorkersPanel(QueryController queryController) {
        super(queryController, false);
    }

    @Override
    QueryData getQueryData() {
        return QueriesData.workers();
    }
}
