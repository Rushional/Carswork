package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;

import javax.swing.*;

public class CarModelsPanel extends TablePanelCRUD {
    public CarModelsPanel(QueryController queryController, DatabaseUpdater databaseUpdater, JFrame parentFrame) {
        super(queryController, databaseUpdater, parentFrame);
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
