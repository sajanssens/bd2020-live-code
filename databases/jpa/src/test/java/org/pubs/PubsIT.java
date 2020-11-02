package org.pubs;

import org.junit.jupiter.api.Test;
import org.pubs.dao.PublisherDao;
import org.pubs.dao.TitleDao;
import org.pubs.dao.Tuple;
import org.pubs.domain.Publisher;
import org.pubs.domain.Title;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PubsIT {

    private final EntityManager em = Persistence.createEntityManagerFactory("pubs").createEntityManager();

    private final PublisherDao publisherDao = new PublisherDao(em);
    private final TitleDao titleDao = new TitleDao(em);

    @Test
    void whenPublisherIsSavedAndGottenThenIsHasAnId() {
        String id = "0011";
        publisherDao.save(new Publisher(id, "ABC"));
        Publisher publisher = publisherDao.get(id);

        assertThat(publisher.getId()).isEqualTo(id);
    }

    @Test
    void whenTitleIsSavedAndGottenThenIsHasAPublisher() {
        Title e = new Title("BU1032", "Test");
        e.setPublisher(new Publisher("1389", "Jansen"));
        titleDao.saveAndDetach(e);

        Title title = titleDao.get("BU1032");

        assertThat(title.getPublisher().getId()).isEqualTo("1389");
    }

    @Test
    void SELECT_Assignment_6_4_native() {
        EntityManager em = Persistence.createEntityManagerFactory("pubs-mysql").createEntityManager();
        TitleDao titleDaoMySql = new TitleDao(em);

        List<Object[]> rows = titleDaoMySql.SELECT_Assignment_6_4_native();

        for (Object[] row : rows) {
            for (Object cell : row) {
                log(cell);
            }
        }
    }

    @Test
    void SELECT_Assignment_6_4() {
        EntityManager em = Persistence.createEntityManagerFactory("pubs-mysql").createEntityManager();
        TitleDao titleDaoMySql = new TitleDao(em);

        List<Tuple> tuples = titleDaoMySql.SELECT_Assignment_6_4();
        tuples.forEach(this::log);
    }

    public void log(Object o) { LoggerFactory.getLogger(getClass()).debug(o.toString()); }

}
