package views.panels;

import queries.QueriesData;
import queries.QueryController;
import queries.QueryData;

public class CarModelsPanel extends TablePanel {
    public CarModelsPanel(QueryController queryController) {
        super(queryController, false);
    }

    @Override
    QueryData getQueryData() {
        return QueriesData.ownedModels();
    }
}
