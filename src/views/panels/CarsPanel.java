package views.panels;

import queries.QueriesData;
import queries.QueryController;
import queries.QueryData;

public class CarsPanel extends TablePanel {
    public CarsPanel(QueryController queryController) {
        super(queryController, false);
    }

    @Override
    QueryData getQueryData() {
        return QueriesData.cars();
    }
}
