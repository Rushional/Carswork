package graphics;

import models.database_interaction.LegacyQueryManager;

import javax.swing.*;
import java.awt.*;

public class LegacyFrame extends JFrame {
    public LegacyResultsDisplayer getLegacyResultsDisplayer() {
        return legacyResultsDisplayer;
    }

    private LegacyResultsDisplayer legacyResultsDisplayer;

    public void setLegacyControlPanel(LegacyControlPanel legacyControlPanel) {
        this.legacyControlPanel = legacyControlPanel;
    }

    private LegacyControlPanel legacyControlPanel;

    public void setLegacyResultsPanel(LegacyResultsPanel legacyResultsPanel) {
        this.legacyResultsPanel = legacyResultsPanel;
    }

    private LegacyResultsPanel legacyResultsPanel;
    private Container pane;

    public LegacyFrame(LegacyQueryManager legacyQueryManager, LegacyResultsDisplayer legacyResultsDisplayer) {
        super("Работа с базой данных");
        this.legacyResultsDisplayer = legacyResultsDisplayer;
        legacyControlPanel = new LegacyControlPanel(legacyQueryManager, legacyResultsDisplayer);
        legacyResultsPanel = new LegacyResultsPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.pane = this.getContentPane();
        pane.setLayout(new GridBagLayout());
        pane.add(legacyControlPanel, legacyControlPanel.getConstraints());
        pane.add(legacyResultsPanel, legacyResultsPanel.getConstraints());
    }

    public void replaceResultsPanel(LegacyResultsPanel newPanel) {
        this.legacyResultsPanel = newPanel;
        pane.add(legacyResultsPanel, legacyResultsPanel.getConstraints());
    }

    public LegacyResultsPanel getLegacyResultsPanel() {
        return legacyResultsPanel;
    }
}
