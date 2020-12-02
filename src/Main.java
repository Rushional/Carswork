import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import queries.MakeQuery;
import queries.QueryStrings;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            MakeQuery.call(session, QueryStrings.getWorkersQuery());
            MakeQuery.call(session, QueryStrings.getOrdersQuery());
            MakeQuery.call(session, QueryStrings.getParametersQuery());
            MakeQuery.call(session, QueryStrings.getServicesQuery());
            MakeQuery.call(session, QueryStrings.getOwnedCarsQuery());
            MakeQuery.call(session, QueryStrings.getPotentialCarsQuery());
            MakeQuery.call(session, QueryStrings.getRentCostsQuery());
            MakeQuery.call(session, QueryStrings.getNumericalParametersDataQuery(4));
            MakeQuery.call(session, QueryStrings.getQualitativeParametersDataQuery(1));
        } finally {
            session.close();
        }
    }
}