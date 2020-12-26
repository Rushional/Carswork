package views.panels;

import queries.QueriesData;
import queries.QueryController;
import queries.QueryData;

public class RecommendationsPanel extends TablePanel {
    public RecommendationsPanel(QueryController queryController) {
        super(queryController, true);
    }

    @Override
    QueryData getQueryData() {
        return QueriesData.parameters();
    }
}
