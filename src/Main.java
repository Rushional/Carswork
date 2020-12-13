import graphics.InterfaceInitiator;
import graphics.ListTuplesToTable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import queries.*;
import views.Initiator;
import views.MainFrame;
import views.ManagerInitiator;
import views.WorkerFrameInitiator;

import javax.persistence.Tuple;
import javax.swing.*;
import java.util.List;

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
//            Initiator interfaceInitiator = new Initiator();
            ManagerInitiator interfaceInitiator = new ManagerInitiator();
            interfaceInitiator.initiateInterface(session);
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