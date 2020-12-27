package views.panels;

import queries.QueriesData;
import controllers.QueryController;
import queries.QueryData;
import queries.SelectQueries;

public class CarsPanel extends TablePanel {
    public CarsPanel(QueryController queryController) {
        super(queryController, false);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.CARS;
    }
}
