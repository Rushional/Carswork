package services;

import models.database_interaction.SessionCreator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Tuple;
import java.util.List;

public class MakeQuery {
    public static List<Tuple> call(SessionCreator sessionCreator, String sqlQuery)
            throws HibernateException {
        final Session session = sessionCreator.getSession();
        Query nativeQuery = session.createNativeQuery(sqlQuery, Tuple.class);
        List<Tuple> tuplesList = (List<Tuple>) nativeQuery.getResultList();
        session.close();
        return tuplesList;
//        try {
//            Query nativeQuery = session.createNativeQuery(sqlQuery, Tuple.class);
//            return (List<Tuple>) nativeQuery.getResultList();
//        } catch (HibernateException e) {
//            session.close();
//            throw e;
//        }
    }
}
