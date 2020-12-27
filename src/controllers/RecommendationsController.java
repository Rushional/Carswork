package controllers;

import controllers.QueryController;
import models.NumericalCorrelationData;
import models.ParameterInfo;
import models.QualCorrelationData;
import queries.SelectQueries;
import services.*;

import javax.persistence.Tuple;
import java.util.List;

// This class RECOMMENDS
// Man, my comments are ON POINT!
// tbh I felt that I needed to explain what this... THING does,
// but I realized I don't fully understand yet how exactly I'm going to implement it
// Alright, now that I've written some code and better see what's up, I can explain it
// This THING gets a list of parameters from the db, calculates
public class RecommendationsController {
    private QueryController queryController;

    public RecommendationsController(QueryController queryController) {
        this.queryController = queryController;
    }

    public void updateDatabaseRatings() {
//        fetch all the recommendations
        List<ParameterInfo> parameterInfoList = FetchParameterInfos.call(queryController);
//        for each one calculate the appropriate correlation and make an update query!
        for (ParameterInfo parameterInfo : parameterInfoList) {
            double systemRating;
            String parameterName = parameterInfo.getParameterTypeName();
            if (parameterInfo.isNumerical()) {
//                Make a numerical parameter query
                List<Tuple> tuplesList = getNumericalTuples(parameterName);
                NumericalCorrelationData correlationData =
                        ConvertTuplesToNumCorrelationData.call(tuplesList);
                systemRating = CalculateNumRating.call(correlationData);
//                Give that thing to the CalculateNumCorrelationService and initiate systemRating
            }
            else {
                List<Tuple> tuplesList = getQualTuples(parameterName);
                QualCorrelationData correlationData =
                        ConvertTuplesToQualCorrelationData.call(tuplesList);
                systemRating = CalculateQualRating.call(correlationData);
            }
//            send an update query with parameterInfo.getParameterTypeName() and systemRating
        }
    }

    private List<Tuple> getNumericalTuples(String parameterName) {
        return queryController.getParameterTable(SelectQueries.NUMERICAL, parameterName);
    }

    private List<Tuple> getQualTuples(String parameterName) {
        return queryController.getParameterTable(SelectQueries.QUALITATIVE, parameterName);
    }
}
