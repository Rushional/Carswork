package services;

import models.ParameterInfo;
import queries.QueriesData;
import queries.QueryController;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

// Makes a query and returns List<ParameterInfo>
public class FetchParameterInfos {
    public static List<ParameterInfo> call(QueryController queryController) {
        List<Tuple> parametersTuples = queryController.getTableData(QueriesData.parametersForCalculation()).getTuplesList();
        List<ParameterInfo> parameterInfoList = new ArrayList<>();
        for (Tuple tuple : parametersTuples) {
            boolean isNumerical = Boolean.parseBoolean((String) tuple.get("is_numerical"));
            parameterInfoList.add(new ParameterInfo((String) tuple.get("parameter_name"), isNumerical));
        }
        return parameterInfoList;
    }
}
