package queries;

public class QueryStrings {
    public static String getWorkersQuery() {
        return (
                "SELECT worker_name, avg_client_feedback\n" +
                "FROM worker"
        );
    }

    public static String getOwnedCarsQuery() {
        return (
                "SELECT name, system_rating, user_feedback\n" +
                "FROM car\n" +
                "INNER JOIN owned_car_data ON pk_car_id = fk_car_id"
        );
    }

    public static String getPotentialCarsQuery() {
        return (
                "SELECT name, system_rating\n" +
                "FROM car\n" +
                "WHERE is_owned = false"
        );
    }

    public static String getOrdersQuery() {
        return (
                "SELECT client_name, worker_name, work_type_name, order_date\n" +
                "FROM order_content\n" +
                "INNER JOIN client ON client_id = pk_client_id\n" +
                "INNER JOIN worker ON worker_id = pk_worker_id\n" +
                "INNER JOIN work_type ON work_type_id = pk_work_type_id"
        );
    }

    public static String getParametersQuery() {
        return (
                "SELECT name, system_rating\n" +
                "FROM car_parameter_type"
        );
    }

//    I probably can simplify next 2 queries so that they don't output a column of the same parameterType id
//    We know it already and I only needed it to filter out everything else
//    I guess I can WHERE without actually outputting the type id
    public static String getNumericalParametersDataQuery(int parameterTypeId) {
        return (
                "SELECT fk_car_parameter_type_id, value, user_feedback\n" +
                "FROM numerical_car_parameter\n" +
                "INNER JOIN car\n" +
                        "\tON fk_car_id = pk_car_id\n" +
                "INNER JOIN owned_car_data\n" +
                        "\tON numerical_car_parameter.fk_car_id = owned_car_data.fk_car_id\n" +
                "WHERE fk_car_parameter_type_id = " + parameterTypeId
        );
    }

    public static String getQualitativeParametersDataQuery(int parameterTypeId) {
        return (
                "SELECT fk_parameter_type_id, pk_variant_id, user_feedback\n" +
                "FROM qualitative_car_parameter\n" +
                "INNER JOIN car\n" +
                        "\tON fk_car_id = pk_car_id\n" +
                "INNER JOIN qualitative_parameter_variant\n" +
                        "\tON fk_parameter_variant_id = pk_variant_id\n" +
                "INNER JOIN owned_car_data\n" +
                        "\tON qualitative_car_parameter.fk_car_id = owned_car_data.fk_car_id\n" +
                "WHERE fk_parameter_type_id = " + parameterTypeId
        );
    }

    public static String getServicesQuery() {
        return (
                "SELECT work_type_name, service_price\n" +
                "FROM work_type\n" +
                "INNER JOIN service_type_price\n" +
                        "\tON pk_work_type_id = fk_work_type_id"
        );
    }

    public static String getRentCostsQuery() {
        return (
                "SELECT name, rent_cost\n" +
                "FROM owned_car_data\n" +
                "INNER JOIN car\n" +
                        "\tON fk_car_id = pk_car_id"
        );
    }
}
