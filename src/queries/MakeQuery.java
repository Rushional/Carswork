package queries;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import java.util.List;

public class MakeQuery {
    public List<Tuple> call(Session session, String sqlQuery) {
        Query nativeQuery = session.createNativeQuery(sqlQuery, Tuple.class);
        return (List<Tuple>) nativeQuery.getResultList();
    }
}
