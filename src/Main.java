import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import views.Initiator;

public class Main {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        double[] horsepower = new double[] {400, 282, 234, 166, 201, 240, 96, 70, 116, 197, 346};
//        double[] feedback = new double[] {4.98, 3.57, 2.93, 2.12, 2.46, 3.09, 1.23, 0.88, 1.45, 2.39, 4.47};
//        System.out.println(CalculateNumCorrelation.call(horsepower, feedback));
        final Session session = getSession();
        try {
            Initiator initiator = new Initiator();
            initiator.initiateInterface(session);
//            QueryController queryController = new QueryController(session);
//            TableData servicesTableData = queryController.getTableData(GetQueryData.selectServices());
//            JTable servicesTable = ListTuplesToTable.call(servicesTableData);
//            System.out.println(servicesTable.getColumnName(1));
//            MakeQuery.call(session, QueryStrings.getWorkersQuery());
//            MakeQuery.call(session, QueryStrings.getOrdersQuery());
//            MakeQuery.call(session, QueryStrings.getParametersQuery());
//            MakeQuery.call(session, QueryStrings.getServicesQuery());
//            MakeQuery.call(session, QueryStrings.getOwnedCarsQuery());
//            MakeQuery.call(session, QueryStrings.getPotentialCarsQuery());
//            MakeQuery.call(session, QueryStrings.getRentCostsQuery());
//            MakeQuery.call(session, QueryStrings.getNumericalParametersDataQuery(4));
//            MakeQuery.call(session, QueryStrings.getQualitativeParametersDataQuery(1));

//            InterfaceInitiator initiator = new InterfaceInitiator(session);
//            initiator.initiateInterface();
        } finally {
            session.close();
        }
    }
}