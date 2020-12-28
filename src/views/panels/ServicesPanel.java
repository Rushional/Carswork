package views.panels;

import controllers.QueryController;
import models.queries.SelectQueries;

public class ServicesPanel extends TablePanelCRUD {
    public ServicesPanel(QueryController queryController) {
        super(queryController);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.SERVICES;
    }
}
