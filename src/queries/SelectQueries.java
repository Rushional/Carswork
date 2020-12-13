package queries;

public class SelectQueries {
    public static String services() {
        return (
                "SELECT work_type_name, service_price\n" +
                "FROM work_type\n" +
                "INNER JOIN service_type_price ON work_type_name = fk_work_type_name"
        );
    }

    public static String carModels() {
        return (
                "SELECT model_name, fk_color_name, license_plate\n" +
                "FROM car\n" +
                "INNER JOIN car_model ON fk_model_name = model_name"
        );
    }

    public static String clientPhoneByName() {
        return (
                "SELECT phone\n" +
                "FROM client\n" +
                "WHERE client_name = 'Бычков Анатолий Семёнович'"
        );
    }

    public static String workers() {
        return (
                "SELECT worker_name, hire_date, birthday\n" +
                "FROM worker"
        );
    }

    public static String orders() {
        return (
                "SELECT pk_order_id AS order_number, client_name, phone, worker_name, work_type_name, start_date, end_date\n" +
                "FROM order_content\n" +
                "INNER JOIN client ON fk_client_name = client_name\n" +
                "INNER JOIN worker ON fk_worker_name = worker_name\n" +
                "INNER JOIN work_type ON fk_work_type_name = work_type_name"
        );
    }
}
