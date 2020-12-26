package views.panels;

import queries.QueriesData;
import queries.QueryController;
import queries.QueryData;

public class OrdersPanel extends TablePanel {
    public OrdersPanel(QueryController queryController) {
        super(queryController, true);
    }

    @Override
    QueryData getQueryData() {
        return QueriesData.orders();
    }
}
