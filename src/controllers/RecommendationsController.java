package controllers;

import models.database_interaction.DatabaseUpdater;
import models.parameters.NumericalCorrelationData;
import models.parameters.ParameterInfo;
import models.parameters.QualCorrelationData;
import models.queries.SelectQueries;
import services.*;

import javax.persistence.Tuple;
import java.util.List;

public class RecommendationsController {
    private QueryController queryController;
    private DatabaseUpdater databaseUpdater;

    public RecommendationsController(QueryController queryController, DatabaseUpdater databaseUpdater) {
        this.queryController = queryController;
        this.databaseUpdater = databaseUpdater;
    }

    public void updateDatabaseRatings() {
//        fetch all the recommendations
        List<ParameterInfo> parameterInfoList = FetchParameterInfos.call(queryController);
//        for each one calculate the appropriate correlation and make an update query!
        for (ParameterInfo parameterInfo : parameterInfoList) {
            double systemRating;
            String parameterName = parameterInfo.getParameterTypeName();
            if (parameterInfo.isNumerical()) {
                List<Tuple> tuplesList = getNumericalTuples(parameterName);
                NumericalCorrelationData correlationData =
                        ConvertTuplesToNumCorrelationData.call(tuplesList);
                systemRating = CalculateNumRating.call(correlationData);
            }
            else {
                List<Tuple> tuplesList = getQualTuples(parameterName);
                QualCorrelationData correlationData =
                        ConvertTuplesToQualCorrelationData.call(tuplesList);
                systemRating = CalculateQualRating.call(correlationData);
            }
            databaseUpdater.updateParameterRating(parameterName, systemRating);
        }
    }

    private List<Tuple> getNumericalTuples(String parameterName) {
        return queryController.getParameterTable(SelectQueries.NUMERICAL, parameterName);
    }

    private List<Tuple> getQualTuples(String parameterName) {
        return queryController.getParameterTable(SelectQueries.QUALITATIVE, parameterName);
    }
}
