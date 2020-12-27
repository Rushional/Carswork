package models;

import queries.QueriesData;
import queries.QueryController;
import queries.QueryData;
import services.CalculateNumRating;
import services.ConvertTuplesToNumCorrelationData;
import services.FetchParameterInfos;

import javax.persistence.Tuple;
import java.util.List;

// This class RECOMMENDS
// Man, my comments are ON POINT!
// tbh I felt that I needed to explain what this... THING does,
// but I realized I don't fully understand yet how exactly I'm going to implement it
public class Recommender {
    private QueryController queryController;

    public Recommender(QueryController queryController) {
        this.queryController = queryController;
    }

    public void updateDatabaseRatings() {
//        fetch all the recommendations
        List<ParameterInfo> parameterInfoList = FetchParameterInfos.call(queryController);
//        for each one calculate the appropriate correlation and make an update query!
        for (ParameterInfo parameterInfo : parameterInfoList) {
            double systemRating;
            if (parameterInfo.isNumerical()) {
//                Make a numerical parameter query
                List<Tuple> tuplesList = getNumericalTuples(parameterInfo.getParameterTypeName());
                NumericalCorrelationData correlationData = ConvertTuplesToNumCorrelationData.call(tuplesList);
                systemRating = CalculateNumRating.call(correlationData);
//                Give that thing to the CalculateNumCorrelationService and initiate systemRating
            }
            else {

            }
//            send an update query with parameterInfo.getParameterTypeName() and systemRating
        }
    }

    private List<Tuple> getNumericalTuples(String parameterName) {
        QueryData queryData = QueriesData.numerical(parameterName);
        return queryController.getTableData(queryData).getTuplesList();
    }


}
