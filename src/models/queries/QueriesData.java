package models.queries;

public class QueriesData {
    public static QueryData workers() {
        return new QueryData(
                new String[]{"ФИО", "Отзывы", "Номер телефона"},
                "SELECT worker_name, avg_client_feedback, phone_number\n" +
                        "FROM worker"
        );
    }

    public static QueryData ownedModels() {
        return new QueryData(
                new String[]{"Название", "Рейтинг", "Отзывы", "Стоимость аренды"},
                "SELECT model_name, system_rating, user_feedback, rent_cost\n" +
                        "FROM car_model\n" +
                        "LEFT JOIN owned_model_data ON model_name = fk_model_name\n" +
                        "WHERE is_owned = true"
        );
    }

    public static QueryData cars() {
        return new QueryData(
                new String[]{"Марка", "Цвет", "Номер"},
                "SELECT model_name, fk_color_name, license_plate\n" +
                        "FROM car\n" +
                        "INNER JOIN car_model ON fk_model_name = model_name"
        );
    }


    public static QueryData potentialModels() {
        return new QueryData(
                new String[]{"Название", "Рейтинг"},
                "SELECT model_name, system_rating\n" +
                        "FROM car_model\n" +
                        "WHERE is_owned = false"
        );
    }

    public static QueryData orders() {
        return new QueryData(
                new String[]{"Клиент", "Телефон", "Сотрудник", "Услуга", "Дата"},
                "SELECT client_name, phone, worker_name, work_type_name, start_date\n" +
                        "FROM order_content\n" +
                        "INNER JOIN client ON client_name = fk_client_name\n" +
                        "INNER JOIN worker ON worker_name = fk_worker_name\n" +
                        "INNER JOIN work_type ON work_type_name = fk_work_type_name"
        );
    }

    public static QueryData parametersOutput() {
        return new QueryData(
                new String[]{"Параметр", "Рейтинг"},
                "SELECT parameter_name, system_rating\n" +
                        "FROM car_parameter_type\n" +
                        "ORDER BY system_rating"
        );
    }

    public static QueryData services() {
        return new QueryData(
                new String[]{"Услуга", "Цена"},
                "SELECT work_type_name, service_price\n" +
                        "FROM work_type\n" +
                        "INNER JOIN service_type_price\n" +
                        "\tON work_type_name = fk_work_type_name"
        );
    }

//     This query won't be converted into a JTable, so I don't need to have good columnNames for it
//     And it's easier to store models.queries and columnNames together - they are basically inseparable
//     I mean, this class saves me the hassle of matching models.queries and column names, if I'd store them separately
    public static QueryData parametersList() {
        return new QueryData(
                null,
                "SELECT parameter_name, is_numerical\n" +
                        "FROM car_parameter_type"
        );
    }

    public static QueryData numerical(String parameter_name) {
        return new QueryData(
                null,
                "SELECT value, user_feedback\n" +
                        "FROM numerical_model_parameter\n" +
                        "INNER JOIN car_model\n" +
                        "\tON model_name = fk_model_name\n" +
                        "INNER JOIN owned_model_data\n" +
                        "\tON numerical_model_parameter.fk_model_name = owned_model_data.fk_model_name\n" +
                        "WHERE fk_parameter_name = '" + parameter_name + "'"
        );
    }

    public static QueryData qualitative(String parameter_name) {
        return new QueryData(
                null,
                "SELECT variant_name, user_feedback\n" +
                        "FROM qualitative_model_parameter\n" +
                        "INNER JOIN car_model\n" +
                        "\tON model_name = fk_model_name\n" +
                        "INNER JOIN qualitative_parameter_variant\n" +
                        "\tON variant_name = fk_variant\n" +
                        "INNER JOIN owned_model_data\n" +
                        "\tON qualitative_model_parameter.fk_model_name = owned_model_data.fk_model_name\n" +
                        "WHERE fk_parameter_name = '" + parameter_name + "'"
        );
    }
}
