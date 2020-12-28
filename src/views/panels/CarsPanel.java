package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;

public class CarsPanel extends TablePanelAddDelete {
    public CarsPanel(QueryController queryController, DatabaseUpdater databaseUpdater) {
        super(queryController, databaseUpdater);
    }

    @Override
    String getTableDatabaseName() {
        return "car";
    }

    @Override
    String getIdentifierColumnName() {
        return "license_plate";
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.CARS;
    }
}
