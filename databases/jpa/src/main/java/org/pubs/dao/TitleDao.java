package org.pubs.dao;

import org.example.dao.Dao;
import org.pubs.domain.Title;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class TitleDao extends Dao<Title, String> {
    public TitleDao(EntityManager em) {
        super(em);
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> SELECT_Assignment_6_4_native() {
        Query nativeQuery = em.createNativeQuery(
                "select pub_id\n" +
                        ",sum(advance) as total\n" +
                        ",avg(price) as average\n" +
                        "from titles\n" +
                        "where price > 5\n" +
                        "and pub_id > '0800'\n" +
                        "group by pub_id\n" +
                        "having sum(advance) > 15000\n" +
                        "and avg(price) < 20\n" +
                        "order by pub_id");

        return (List<Object[]>) nativeQuery.getResultList();
    }

    @SuppressWarnings("rawtypes")
    public List<Tuple> SELECT_Assignment_6_4() {
        TypedQuery<Tuple> query = em.createQuery(
                "select new org.pubs.dao.Tuple(t.publisher, sum(t.advance), avg(t.price))" +
                        "from Title t " +
                        "where t.price > 5\n" +
                        "and t.publisher.id > '0800'\n" +
                        "group by t.publisher.id\n" +
                        "having sum(t.advance) > 15000\n" +
                        "and avg(t.price) < 20\n" +
                        "order by t.publisher.id", Tuple.class);

        return query.getResultList();
    }

}
