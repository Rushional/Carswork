package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;

public class ServicesPanel extends TablePanelCRUD {
    public ServicesPanel(QueryController queryController, DatabaseUpdater databaseUpdater) {
        super(queryController, databaseUpdater);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.SERVICES;
    }

    @Override
    String getTableDatabaseName() {
        return "work_type";
    }

    @Override
    String getIdentifierColumnName() {
        return "work_type_name";
    }
}
