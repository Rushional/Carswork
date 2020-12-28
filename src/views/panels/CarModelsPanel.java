package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;

public class CarModelsPanel extends TablePanelCRUD {
    public CarModelsPanel(QueryController queryController, DatabaseUpdater databaseUpdater) {
        super(queryController, databaseUpdater);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.OWNED_MODELS;
    }

    @Override
    String getTableDatabaseName() {
        return "car_model";
    }

    @Override
    String getIdentifierColumnName() {
        return "model_name";
    }
}
