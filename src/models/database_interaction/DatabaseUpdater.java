package models.database_interaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import views.dialogs.CarData;
import views.dialogs.CarModelData;
import views.dialogs.ServiceData;
import views.dialogs.WorkerData;

// Makes update queries with given parameters, knows all the needed query strings already
public class DatabaseUpdater {
    private SessionCreator sessionCreator;

    public DatabaseUpdater(SessionCreator sessionCreator) {
        this.sessionCreator = sessionCreator;
    }

    private void executeQuery(String query) {
        final Session s = sessionCreator.getSession();
        try {
            s.getTransaction().begin();
            s.createSQLQuery(query).executeUpdate();
            s.getTransaction().commit();
            s.close();
        }
        catch (HibernateException erro){
            s.getTransaction().rollback();
            s.close();
        }
    }

    public void updateParameterRating(String parameterName, double rating) {
        String parameterQuery =
                "UPDATE public.car_parameter_type\n" +
                 "\tSET system_rating = " + rating + "\n" +
                 "\tWHERE parameter_name = '" + parameterName + "'";
        executeQuery(parameterQuery);
    }

    public void deleteEntry(String databaseName, String identifierColumnName, String identifier) {
        String deleteQuery =
                "DELETE FROM " + databaseName + "\n" +
                 "\tWHERE " + identifierColumnName + " = '" + identifier + "'";
        executeQuery(deleteQuery);
    }

//    I could go with some crazy OOP generalization method to avoid duplicating my code
//    but in this situation it's a bit too complicated and bothersome to do.
//    It would probably be a good idea to do at some point to make the code clearer,
//    so I guess TODO, but - yet again - low priority
    public void updateWorker(String identifier, String phoneNumber) {
        String updateWorkerQuery =
                "UPDATE worker\n" +
                 "\tSET phone_number = '" + phoneNumber + "'\n" +
                 "\tWHERE worker_name = '" + identifier + "'";
        executeQuery(updateWorkerQuery);
    }

    public void updateCarModels(String identifier, double rentCost) {
        String updateCarModelsQuery =
                "UPDATE owned_model_data\n" +
                 "\tSET rent_cost = '" + rentCost + "'\n" +
                 "\tWHERE fk_model_name = '" + identifier + "'";
        executeQuery(updateCarModelsQuery);
    }

    public void updateServices(String identifier, double servicePrice) {
        String updateServicesQuery =
                "UPDATE service_type_price\n" +
                 "\tSET service_price = '" + servicePrice + "'\n" +
                 "\tWHERE fk_work_type_name = '" + identifier + "'";
        executeQuery(updateServicesQuery);
    }

    public void addWorker(WorkerData addedData) {
        String addWorkerQuery =
                "INSERT INTO worker(\n" +
                 "\tworker_name, birthday, hire_date, phone_number)\n" +
                 "\tVALUES (" +
                        "'" + addedData.getName() + "', " +
                        "'" + addedData.getBirth() + "', " +
                        "'" + addedData.getHire() + "', " +
                        "'" + addedData.getPhone() + "'" +
                        ");";
        executeQuery(addWorkerQuery);
    }

    public void addCarModel(CarModelData addedData) {
        String addModelQuery =
                "INSERT INTO car_model(\n" +
                 "\tmodel_name, is_owned)\n" +
                 "\tVALUES ('" + addedData.getName() + "', true);";
        executeQuery(addModelQuery);
        String addDataQuery =
                "INSERT INTO public.owned_model_data(\n" +
                        "\tfk_model_name, rent_cost)\n" +
                        "\tVALUES ('" + addedData.getName() + "', " + addedData.getCost() + ");";
        executeQuery(addDataQuery);
    }

    public void addCar(CarData addedData) {
        String addCarQuery =
                "INSERT INTO car(\n" +
                        "\tlicense_plate, fk_model_name, fk_color_name)\n" +
                        "\tVALUES (" +
                        "'" + addedData.getLicensePlate() + "', " +
                        "'" + addedData.getModelName() + "', " +
                        "'" + addedData.getColor() + "'" +
                        ");";
        executeQuery(addCarQuery);
    }

    public void addService(ServiceData addedData) {
        String addServiceQuery =
                "INSERT INTO work_type(\n" +
                 "\twork_type_name)\n" +
                 "\tVALUES ('" + addedData.getName() + "');";
        executeQuery(addServiceQuery);
        String addPriceQuery =
                "INSERT INTO service_type_price(\n" +
                 "\tfk_work_type_name, service_price)\n" +
                 "\tVALUES ('" + addedData.getName() + "', '" + addedData.getPrice() + "');";
        executeQuery(addPriceQuery);
    }
}
