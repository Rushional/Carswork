package models;

public class NumericalCorrelationData {
    private double[] values;
    private double[] userFeedback;

    public NumericalCorrelationData(double[] values, double[] userFeedback) {
        this.values = values;
        this.userFeedback = userFeedback;
    }

    public double[] getValues() {
        return values;
    }

    public double[] getUserFeedback() {
        return userFeedback;
    }
}
