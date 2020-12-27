package models;

import java.util.List;

public class QualCorrelationData {
    private List<double[]> categoriesFeedbackList;

    public QualCorrelationData(List<double[]> categoriesFeedbackList) {
        this.categoriesFeedbackList = categoriesFeedbackList;
    }

    public List<double[]> getCategoriesFeedbackList() {
        return categoriesFeedbackList;
    }
}
