package interface_interaction;

import queries.QueryManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerProblemsByDateComboListenerWorker implements ActionListener {
    private QueryManager queryManager;

    public WorkerProblemsByDateComboListenerWorker(QueryManager queryManager) {
        this.queryManager = queryManager;
    }

    public void actionPerformed(ActionEvent e) {
        WorkerProblemsByDateComboBoxWorker workerProblemsByDateComboBoxWorker = (WorkerProblemsByDateComboBoxWorker) e.getSource();
        int index = workerProblemsByDateComboBoxWorker.getSelectedIndex();
        int workerId = (int)queryManager.getWorkerNames().get(index).get("id");
        queryManager.setWorkerId(workerId);
        queryManager.setWorkerName((String)workerProblemsByDateComboBoxWorker.getSelectedItem());
    }
}
