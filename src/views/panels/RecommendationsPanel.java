package views.panels;

import controllers.QueryController;
import queries.SelectQueries;

public class RecommendationsPanel extends TablePanel {
    public RecommendationsPanel(QueryController queryController) {
        super(queryController, true);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.PARAMETERS_OUTPUT;
    }
}
