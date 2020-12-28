package views.panels;

import controllers.QueryController;
import models.queries.SelectQueries;

public class WorkersPanel extends TablePanelCRUD {
    public WorkersPanel(QueryController queryController) {
        super(queryController);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.WORKERS;
    }
}
