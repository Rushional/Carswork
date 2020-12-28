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
}
