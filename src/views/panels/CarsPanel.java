package views.panels;

import controllers.QueryController;
import models.queries.SelectQueries;

public class CarsPanel extends TablePanelAddDelete {
    public CarsPanel(QueryController queryController) {
        super(queryController);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.CARS;
    }
}
