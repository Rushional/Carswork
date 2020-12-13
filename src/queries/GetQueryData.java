package queries;

public class GetQueryData {
    public static QueryData selectServices() {
        return new QueryData(new String[]{"Услуга", "Цена"}, SelectQueries.services());
    }

    public static QueryData selectCars() {
        return new QueryData(new String[]{"Марка", "Цвет", "Номер"}, SelectQueries.carModels());
    }

    public static QueryData selectClientPhoneByName() {
        return new QueryData(new String[]{"Телефон"}, SelectQueries.clientPhoneByName());
    }

    public static QueryData selectWorkers() {
        return new QueryData(new String[]{"ФИО", "Дата принятия на работу", "Дата рождения"}, SelectQueries.workers());
    }

    public static QueryData selectOrders() {
        return new QueryData(new String[]{"№", "ФИО клиента", "Телефон клиента",
                "ФИО сотрудника", "Услуга", "Начало работы", "Конец работы"},
                SelectQueries.orders());
    }
}
