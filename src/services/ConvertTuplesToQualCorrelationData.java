package services;

import models.parameters.QualCorrelationData;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class ConvertTuplesToQualCorrelationData {
    public static QualCorrelationData call(List<Tuple> tuplesList) {
//        Create a HashMap<String, List<Double>>. We're using a List and not an array because
//        the expected size is unknown, fill it with data from the tuples
        Map<String, ArrayList<Double>> qualDataMap = new HashMap<>();
        for (Tuple tuple : tuplesList) {
            String variantName = (String) tuple.get("variant_name");
            Double feedback = (Double) tuple.get("user_feedback");
            if (qualDataMap.containsKey(variantName)) {
                qualDataMap.get(variantName).add(feedback);
            } else {
                ArrayList<Double> variantFeedbacksList = new ArrayList<>();
                qualDataMap.put(variantName, variantFeedbacksList);
                variantFeedbacksList.add(feedback);
            }
        }
        List<double[]> qualCorrelationArrays = new ArrayList<>();
        qualDataMap.forEach((s, doubles) -> {
            int amount = doubles.size();
            double[] feedbacksArray = new double[amount];
            for (int i = 0; i < amount; i++) {
                feedbacksArray[i] = doubles.get(i);
            }
            qualCorrelationArrays.add(feedbacksArray);
        });
        return new QualCorrelationData(qualCorrelationArrays);
    }
}
