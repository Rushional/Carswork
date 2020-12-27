package views.panels;

import queries.QueriesData;
import controllers.QueryController;
import queries.QueryData;
import queries.SelectQueries;

public class OrdersPanel extends TablePanel {
    public OrdersPanel(QueryController queryController) {
        super(queryController, true);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.ORDERS;
    }
}
