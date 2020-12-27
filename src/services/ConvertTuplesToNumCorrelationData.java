package services;

import models.NumericalCorrelationData;

import javax.persistence.Tuple;
import java.util.List;

public class ConvertTuplesToNumCorrelationData {
    public static NumericalCorrelationData call(List<Tuple> tuplesList) {
        int size = tuplesList.size();
        double[] values = new double[size];
        double[] userFeedback = new double[size];
        for (int i = 0; i < size; i++) {
            values[i] = fetchValue(tuplesList.get(i));
            userFeedback[i] = fetchFeedback(tuplesList.get(i));
        }
        return new NumericalCorrelationData(values, userFeedback);
    }

    private static double fetchValue(Tuple tuple) {
        return Double.parseDouble((String) tuple.get("value"));
    }

    private static double fetchFeedback(Tuple tuple) {
        return Double.parseDouble((String) tuple.get("user_feedback"));
    }
}
