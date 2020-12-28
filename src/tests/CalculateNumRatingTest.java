package tests;

import models.parameters.NumericalCorrelationData;
import org.junit.jupiter.api.Test;
import services.CalculateNumRating;

import static org.junit.jupiter.api.Assertions.*;

class CalculateNumRatingTest {

    @Test
    void call() {
        double[] horsepower = new double[] {400, 282, 234, 166, 201, 240, 96, 70, 116, 197, 346};
        double[] feedback = new double[] {4.98, 3.57, 2.93, 2.12, 2.46, 3.09, 1.23, 0.88, 1.45, 2.39, 4.47};
        NumericalCorrelationData numData = new NumericalCorrelationData(horsepower, feedback);
        double rating = CalculateNumRating.call(numData);
        assertEquals(4.995, rating);
//        CalculateNumRating.call()
    }
}