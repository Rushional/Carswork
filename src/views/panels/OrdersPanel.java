package views.panels;

import controllers.QueryController;
import models.queries.SelectQueries;

public class OrdersPanel extends TablePanel {
    public OrdersPanel(QueryController queryController) {
        super(queryController);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.ORDERS;
    }
}
