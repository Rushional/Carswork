package services;

import models.parameters.ParameterInfo;
import controllers.QueryController;
import models.queries.SelectQueries;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

// Makes a query and returns List<ParameterInfo>
public class FetchParameterInfos {
    public static List<ParameterInfo> call(QueryController queryController) {
        List<Tuple> parametersTuples = queryController.getTableData(SelectQueries.PARAMETERS_LIST)
                .getTuplesList();
        List<ParameterInfo> parameterInfoList = new ArrayList<>();
        for (Tuple tuple : parametersTuples) {
//            boolean isNumerical = Boolean.parseBoolean((String) tuple.get("is_numerical"));
//            Wait I thought it was a string
            boolean isNumerical = (boolean) tuple.get("is_numerical");
            parameterInfoList.add(new ParameterInfo((String) tuple.get("parameter_name"), isNumerical));
        }
        return parameterInfoList;
    }
}
