package views;

import org.hibernate.Session;
import views.panels.CarModelsPanel;
import views.panels.OutputPanel;
import views.panels.ServicesPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(Session session) {
        super("Управление автосервисом");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Марки машин", new OutputPanel());
        tabbedPane.addTab("Машины", new CarModelsPanel(session));
        tabbedPane.addTab("Заказы", new OutputPanel());
        tabbedPane.addTab("Рекомендации", new OutputPanel());
        tabbedPane.addTab("Услуги", new ServicesPanel(session));
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
