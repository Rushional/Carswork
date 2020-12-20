package queries;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
// This... thing should store stuff and make QueryMakers, not do everything at the same time
// So when I'm done with it, it will only call MakeQuery.call() with the correct parameters
// That's probably it.
// Even getting lists of possible arguments for the user should be done elsewhere
// And it probably should be done with MakeQuery too, ironically
public class LegacyQueryManager {
    private Session session;
    //Stored info for workerProblemsBydate query
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String queryTimePeriod = null;
    private int workerId = -1;

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    private String workerName;

    public List<Tuple> getCarNames() {
        return carNames;
    }

    public List<Tuple> getWorkerNames() {
        return workerNames;
    }

    public List<Tuple> getClientNames() {
        return clientNames;
    }

    private List<Tuple> carNames;
    private List<Tuple> workerNames;
    private List<Tuple> clientNames;

    public LegacyQueryManager(Session session) {
        this.session = session;
//        this.dateFormat = new SimpleDateFormat(pattern);
    }

    private List<Tuple> queryGetTuples(String sqlQuery) {
        Query nativeQuery = session.createNativeQuery(sqlQuery, Tuple.class);
        List<Tuple> nativeQueryResults = nativeQuery.getResultList();
        return nativeQueryResults;
    }

    public void createQueryOptions() {
        carNames = loadCarNames();
        workerNames = loadWorkerNames();
        clientNames = loadClientNames();
    }

    private List<Tuple> loadCarNames() { return queryGetTuples("SELECT car_name, pk_car_id as id FROM car"); }
    private List<Tuple> loadWorkerNames() { return queryGetTuples("SELECT worker_name, pk_worker_id as id FROM worker"); }
    private List<Tuple> loadClientNames() { return queryGetTuples("SELECT client_name, pk_client_id as id FROM client"); }

    //task 1
    public List<Tuple> workTypes() {
            return queryGetTuples("SELECT work_type_name, price FROM work_type;");
    }

    //task 2
    public List<Tuple> carsClients() {
        return queryGetTuples(
                "SELECT car_name, client_name " +
                "FROM car INNER JOIN client " +
                "ON fk_client_id=pk_client_id;"
        );
    }

    //task 3
    public List<Tuple> carWorks(int carID) {
        return queryGetTuples(
                "SELECT work_type_name " +
                "FROM problem " +
                "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                "WHERE car_id="+carID+";"
        );
    }

    //task 4
    public List<Tuple> workerProblemsByDate() {
        if (queryTimePeriod != null && workerId != -1) {
            Date right = new Date(); //today date
            String rightDate = dateFormat.format(right);
            String leftDate = calculateDate(right);
            return queryGetTuples(
                    "SELECT car_name, client_name, work_type_name, delivery_date " +
                            "FROM problem " +
                            "INNER JOIN car ON car_id=pk_car_id " +
                            "INNER JOIN client ON fk_client_id=pk_client_id " +
                            "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                            "WHERE worker_id=" + workerId + " AND delivery_date BETWEEN DATE '" + leftDate + "' AND DATE '" + rightDate + "';"
            );
        }
        else return null;
    }

    //task 5
    public double clientCost(int clientID) {
        final Query query5clientCost = session.createSQLQuery(
                "SELECT " +
                "SUM (price) AS total_cost " +
                "FROM client " +
                "INNER JOIN car ON pk_client_id=fk_client_id " +
                "INNER JOIN problem ON pk_car_id=car_id " +
                "INNER JOIN work_type ON work_type_id=pk_work_type_id " +
                "WHERE pk_client_id=" + clientID + ";"
        );
        double totalCost = 0;
        for (Object o : query5clientCost.list()) {
            totalCost = (double)o;
        }
        return totalCost;
    }

//    TODO: You do realize you can calculate dates, right?
    private String calculateDate(Date right) {
        if (right != null) {
            switch (queryTimePeriod) {
                case "Past day":
                    return "2019-12-22";
                case "Past week":
                    return "2019-12-16";
                case "Past month":
                    return "2019-11-23";
                case "Past quarter of a year":
                    return "2019-09-23";
                case "Past year":
                    return "2018-12-23";
                default:
                    return null;
            }
        }
        else return null;
    }

    public void setQueryTimePeriod(String queryTimePeriod) {
        this.queryTimePeriod = queryTimePeriod;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getQueryTimePeriod() {
        return queryTimePeriod;
    }

    public int getWorkerId() {
        return workerId;
    }
}
