package views;

import models.database_interaction.DatabaseUpdater;
import models.database_interaction.SessionCreator;
import controllers.QueryController;
import views.panels.*;

import javax.swing.*;
import java.awt.*;

// Could be a singleton
public class Frame extends JFrame {
    public Frame(SessionCreator sessionCreator) {
        super("Управление автосервисом");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QueryController queryController = new QueryController(sessionCreator);
        DatabaseUpdater databaseUpdater = new DatabaseUpdater(sessionCreator);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Сотрудники", new WorkersPanel(queryController, databaseUpdater));
        tabbedPane.addTab("Марки машин", new CarModelsPanel(queryController, databaseUpdater));
        tabbedPane.addTab("Машины", new CarsPanel(queryController, databaseUpdater));
        tabbedPane.addTab("Заказы", new OrdersPanel(queryController));
        tabbedPane.addTab("Рекомендации", new RecommendationsPanel(queryController));
        tabbedPane.addTab("Услуги", new ServicesPanel(queryController, databaseUpdater));
        add(tabbedPane, BorderLayout.WEST);
        setResizable(false);
    }

    private GridBagConstraints getResultsPanelConstraints() {
        GridBagConstraints resultsPanelConstraints = new GridBagConstraints();
        resultsPanelConstraints.fill = GridBagConstraints.BOTH;
        resultsPanelConstraints.weightx = 0;
        resultsPanelConstraints.weighty = 0;
        resultsPanelConstraints.gridx = 1;
        resultsPanelConstraints.gridy = 0;
        return resultsPanelConstraints;
    }

    private GridBagConstraints getControlPanelConstraints() {
        GridBagConstraints controlPanelConstraints = new GridBagConstraints();
        controlPanelConstraints.fill = GridBagConstraints.BOTH;
        controlPanelConstraints.weightx = 0;
        controlPanelConstraints.weighty = 0;
        controlPanelConstraints.gridx = 0;
        controlPanelConstraints.gridy = 0;
        return controlPanelConstraints;
    }
}
