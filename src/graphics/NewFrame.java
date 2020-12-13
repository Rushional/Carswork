package graphics;

import queries.QueryManager;

import javax.swing.*;
import java.awt.*;

// TODO: rename to Frame or whatever
public class NewFrame extends JFrame {
    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    private ControlPanel controlPanel;

    public void setResultsPanel(ResultsPanel resultsPanel) {
        this.resultsPanel = resultsPanel;
    }

    private ResultsPanel resultsPanel;
    private Container pane;

    public NewFrame(QueryManager queryManager, ResultsDisplayer resultsDisplayer) {
        super("Работа с базой данных");
        controlPanel = new ControlPanel(queryManager, resultsDisplayer);
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
