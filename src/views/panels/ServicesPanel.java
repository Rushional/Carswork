package views.panels;

import queries.QueriesData;
import queries.QueryController;
import queries.QueryData;

public class ServicesPanel extends TablePanel {
    public ServicesPanel(QueryController queryController) {
        super(queryController, false);
    }

    @Override
    QueryData getQueryData() {
        return QueriesData.services();
    }
}
