package models;

public class CalculateNumCorrelation {
    public static double call(double[] values, double[] feedback) {
//        I don't want to bother making some kind of ValuesFeedback class
//        or - worse yet - link models and views via the Tuple class.
//        So I decided to use simple arrays, yeah -  forcing the programmer remember to use this correctly
//        It's kinda bad, but it's simple so that's what I'm going with
        int amount = values.length;
        if (amount != feedback.length) throw new RuntimeException();
        double valuesSum = 0;
        double feedbackSum = 0;
        for (int i = 0; i < amount; i++) {
            valuesSum += values[i];
            feedbackSum += feedback[i];
        }
        double averageValue = valuesSum/amount;
        double averageFeedback = feedbackSum/amount;
        double numeratorSum = 0; // That's that thing up there in a fraction
        double dividerValueSum = 0;
        double dividerFeedbackSum = 0;
        for (int i = 0; i < amount; i++) {
            numeratorSum += (values[i] - averageValue)*(feedback[i] - averageValue);
            dividerValueSum += Math.pow(values[i] - averageValue , 2);
            dividerFeedbackSum += Math.pow(feedback[i] - averageFeedback , 2);
        }
        return numeratorSum/Math.sqrt(dividerValueSum*dividerFeedbackSum);
    }
}
