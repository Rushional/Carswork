package views.panels;

import queries.QueriesData;
import controllers.QueryController;
import queries.QueryData;
import queries.SelectQueries;

public class ServicesPanel extends TablePanel {
    public ServicesPanel(QueryController queryController) {
        super(queryController, false);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.SERVICES;
    }
}
