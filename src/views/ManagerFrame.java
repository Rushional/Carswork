package views;

import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;

public class ManagerFrame extends JFrame {
    public ManagerFrame(Session session) {
        super("Менеджер");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Сотрудники", new WorkersPanel(session));
        tabbedPane.addTab("Клиенты", new OutputPanel());
        tabbedPane.addTab("Заявки", new OrdersPanel(session));
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
