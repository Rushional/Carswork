package views.panels;

import queries.QueriesData;
import controllers.QueryController;
import queries.QueryData;
import queries.SelectQueries;

public class WorkersPanel extends TablePanel {
    public WorkersPanel(QueryController queryController) {
        super(queryController, false);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.WORKERS;
    }
}
