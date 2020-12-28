package services;

import models.parameters.QualCorrelationData;
import org.apache.commons.math3.stat.inference.OneWayAnova;

public class CalculateQualRating {
    public static double call(QualCorrelationData qualInputData) {
        var oneWayAnova = new OneWayAnova();
        double pValue = oneWayAnova.anovaPValue(qualInputData.getCategoriesFeedbackList());
        /*
        * It turned out there was no easy enough way to calculate a categorical-numerical
        * correlation that is efficiently comparable to a numeric correlation.
        * There are basically 3 ways to calculate such a correlation.
        * I really would like to use the best one, but it's also the hardest one:c
        * 1) Ordinal regression would do it all and more, but it's usually done with R or MatLab,
        * there are no libs for Java, and it's too complicated to make one from scratch.
        * We only have so much time and expendable effort
        * 2) Among those easier 2 one of them - Point biserial correlation - immediately fails us,
        * because it only works with binary partition, whereas our parameters can have however many
        * variants, e.g. gas types. 2 options just isn't enough.
        * 3) We're left with a Kruskal Wallis H Test or - a bit better - ANOVA.
        * This thing can find a link between numerical and categorical data, but...
        * It can't find out how significant that link is, unfortunately. It just finds out if
        * the link exists. It's already something for us, so I decided to use it, but well,
        * it's second best. The problem is that the best solution is way WAY harder to implement.
        * And, honestly, I want to learn to write another kind of code, and spending A LOT of time
        * on implementing ordinal regression would be quite a waste for me. Instead of learning Java
        * and stuff I'd be learning statistics. Have mercy!
        */
        if (pValue < 0.5) return 4.5;
        else return 1.0;
    }
}
