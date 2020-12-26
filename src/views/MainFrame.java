package views;

import org.hibernate.Session;
import queries.QueryController;
import views.panels.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(Session session) {
        super("Управление автосервисом");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        QueryController queryController = new QueryController(session);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Сотрудники", new WorkersPanel(queryController));
        tabbedPane.addTab("Марки машин", new CarModelsPanel(queryController));
        tabbedPane.addTab("Машины", new CarsPanel(queryController));
        tabbedPane.addTab("Заказы", new OrdersPanel(queryController));
        tabbedPane.addTab("Рекомендации", new RecommendationsPanel(queryController));
        tabbedPane.addTab("Услуги", new ServicesPanel(queryController));
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
