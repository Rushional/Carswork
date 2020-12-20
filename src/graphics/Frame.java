package graphics;

import queries.LegacyQueryManager;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public ResultsDisplayer getResultsDisplayer() {
        return resultsDisplayer;
    }

    private ResultsDisplayer resultsDisplayer;

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    private ControlPanel controlPanel;

    public void setResultsPanel(ResultsPanel resultsPanel) {
        this.resultsPanel = resultsPanel;
    }

    private ResultsPanel resultsPanel;
    private Container pane;

    public Frame(LegacyQueryManager legacyQueryManager, ResultsDisplayer resultsDisplayer) {
        super("Работа с базой данных");
        this.resultsDisplayer = resultsDisplayer;
        controlPanel = new ControlPanel(legacyQueryManager, resultsDisplayer);
        resultsPanel = new ResultsPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.pane = this.getContentPane();
        pane.setLayout(new GridBagLayout());
        pane.add(controlPanel, controlPanel.getConstraints());
        pane.add(resultsPanel, resultsPanel.getConstraints());
    }

    public void replaceResultsPanel(ResultsPanel newPanel) {
        this.resultsPanel = newPanel;
        pane.add(resultsPanel, resultsPanel.getConstraints());
    }

    public ResultsPanel getResultsPanel() {
        return resultsPanel;
    }
}
