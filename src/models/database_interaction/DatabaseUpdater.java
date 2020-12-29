package models.database_interaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;

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
}
