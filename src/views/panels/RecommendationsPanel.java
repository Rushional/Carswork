package views.panels;

import controllers.QueryController;
import models.queries.SelectQueries;

public class RecommendationsPanel extends TablePanel {
    public RecommendationsPanel(QueryController queryController) {
        super(queryController);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.PARAMETERS_OUTPUT;
    }
}
