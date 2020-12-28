package views.panels;

import controllers.QueryController;
import models.queries.SelectQueries;

public class CarModelsPanel extends TablePanelCRUD {
    public CarModelsPanel(QueryController queryController) {
        super(queryController);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.OWNED_MODELS;
    }
}
