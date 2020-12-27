package views.panels;

import queries.QueriesData;
import controllers.QueryController;
import queries.QueryData;
import queries.SelectQueries;

public class CarModelsPanel extends TablePanel {
    public CarModelsPanel(QueryController queryController) {
        super(queryController, false);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.OWNED_MODELS;
    }
}
