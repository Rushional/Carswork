package views.panels;

import controllers.QueryController;
import models.database_interaction.DatabaseUpdater;
import models.queries.SelectQueries;

public class WorkersPanel extends TablePanelCRUD {
    public WorkersPanel(QueryController queryController, DatabaseUpdater databaseUpdater) {
        super(queryController, databaseUpdater);
    }

    @Override
    SelectQueries getQueryEnum() {
        return SelectQueries.WORKERS;
    }

    @Override
    String getTableDatabaseName() {
        return "worker";
    }

    @Override
    String getIdentifierColumnName() {
        return "worker_name";
    }
}
